package isg.pfe.travelAgency.ServicesImplementation;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.internal.ApiResponse;
import com.google.maps.model.*;
import isg.pfe.travelAgency.Entities.Location;
import isg.pfe.travelAgency.Repositories.LocationRepository;
import isg.pfe.travelAgency.Services.LocationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.sql.Array;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class LocationServicesImpl implements LocationServices {
    int[] visited;
    int[]path;
    int pathIndex=0;
    Vector<Vector<Long>> G=new Vector<Vector<Long>>();
    Long cost=new Long(0);
    @Autowired
    LocationRepository locationRepository;
    Long[][]G1;
    int[] route;

    @Override
    public ResponseEntity<?> SaveLocation(Location location) {
        Optional<Location> l=locationRepository.findByLatitudeAndLongitude(location.getLatitude(),location.getLongitude());
        if(l.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        return new ResponseEntity<>(locationRepository.save(location), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<List<Location>> ListLocations() {
        List<Location>list=locationRepository.findAll();
        if (list.isEmpty())
        return new ResponseEntity(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(list,HttpStatus.OK) ;
    }

    @Override
    public ResponseEntity DeleteLocation(Integer id ) {
        Optional<Location> location = locationRepository.findById(id);
        if (!location.isPresent())
        return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   locationRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);}
    }

    @Override
    public ResponseEntity UpdateLocation(Integer id, Location newLocation) {
        Optional<Location> location = locationRepository.findById(id);
        if (!location.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        else
        {   newLocation.setId(id);
            Location location1=locationRepository.save(newLocation);
            return new ResponseEntity(location1,HttpStatus.ACCEPTED);}
    }

    @Override
    public ResponseEntity FindLocation(Integer id) {
        Optional<Location> location=locationRepository.findById(id);
        if(!location.isPresent())
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(location.get(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity Optimize(List<Location> locations) {
        GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyC2muCN8uI6W9J-Vq3xLibonkUXsAiFmss").setQueryRateLimit(30);
        int locSize=locations.size();
        LatLng[] latLngs=new LatLng[locSize];
        int k=0;
        cost=new Long(0);
        Long duration=new Long(0);
        pathIndex=0;
        for (Location location:locations ) {

            latLngs[k]=new LatLng(location.getLatitude(),location.getLongitude());
            k++;
        }
        //DistanceMatrix distanceMatrix= DistanceMatrixApi.getDistanceMatrix(null, new LatLng(locations.get(0).getLatitude(),locations.get(0).getLongitude()),null).wait();
        // DistanceMatrix dis=DistanceMatrixApi.newRequest(null).origins(new LatLng(locations.get(0).getLatitude(),locations.get(0).getLongitude())).destinations(new LatLng(locations.get(0).getLatitude(),locations.get(0).getLongitude())).mode(TravelMode.DRIVING).units(Unit.METRIC).awaitIgnoreError();
        G1=new Long[locSize][locSize];
        visited=new int[locSize];
        DistanceMatrix dis=null;
        path=new int[locSize];
        try {
                    dis=DistanceMatrixApi.newRequest(context).origins(latLngs)
                    .destinations(latLngs)
                    .mode(TravelMode.DRIVING)
                    .units(Unit.METRIC)
                    .await();

            DistanceMatrixElement element;
            //TimeUnit.MILLISECONDS.sleep(1000);
        } catch (Exception e) {
               System.out.println(e.getMessage()+"---->"+e.fillInStackTrace()+e.getCause());
            }
            for (int i=0;i<locSize;i++){

                DistanceMatrixRow row =dis.rows[i];
                for(int j=0;j<locSize;j++){

                        G1[i][j]=row.elements[j].distance.inMeters;
                        System.out.print("  "+G1[i][j]);
                }



                System.out.println("");
                //visited[i]=0;
                //int start=0;

                //path[1]=locSize-1;
                //pathIndex++;
                //visited[locSize-1]=1;
                 //   TSP(start);


            }

//        for (int i=0;i<locSize;i++){
//            for (int j=0;j<locSize;j++){
//                G1[j][i]=G1[i][j];
//                System.out.print("  "+G1[i][j]);
//            }
//            System.out.println("");
//
//        }
            route=new int[locSize];
            for (int i=0;i<locSize;i++ )
                route[i]=i;
            Route res;
            if(locSize<=3)
                res=new Route(route);
            else{
            res=findRoute(999.0,new Route(route));}
            //findMinRoute(G1);
            //DistanceMatrixRow dr = dis.rows[0];
           // Long distance = Arrays.stream(dr.elements).mapToLong(distanceMatrixElement -> distanceMatrixElement.distance.inMeters).sum();
           // System.out.println("/n/n the distance is :" + distance);
            route= res.route;
            System.out.println(Arrays.toString(res.route));
            List<Location> list =new ArrayList<Location>();
            for(int i=0;i<route.length;i++){

                    list.add(locations.get(route[i]));

            }
        for (int i=0;i<locSize;i++){

            DistanceMatrixRow row =dis.rows[i];
            for(int j=0;j<locSize;j++){

                G1[i][j]=row.elements[j].duration.inSeconds;
                System.out.print("  "+G1[i][j]);
            }
        }
         for(int i=0;i<locSize-1;i++){
             duration+=G1[route[i]][route[i+1]]+300;

         }
         route=new int[locSize];
        G1=new Long[locSize][locSize];
        visited=new int[locSize];
        dis=null;
        path=new int[locSize];
            return new ResponseEntity(new LocationDuration(list,duration), HttpStatus.OK);

       // } catch (Exception e) {
         //   System.out.println(e.getMessage()+"---->"+e.fillInStackTrace()+e.getCause());
        //}

        //return new ResponseEntity( HttpStatus.FAILED_DEPENDENCY);
    }
    void TSP(int node){
    int nextNode;

    visited[node]=1;
    path[pathIndex]=node;
    pathIndex++;
    nextNode=findNextNode(node);
    if(nextNode==Integer.MAX_VALUE){
            int v=0;
            cost+=G1[nextNode][v];
            return ;
        }

    }
    int findNextNode(int node){
       int nd,minIndex=0;
       Long demoCost=new Long(0),min=Long.MAX_VALUE;
       for (int i=0;i<visited.length;i++){
           if(visited[i]==0 && G1[node][i]!=0 && G1[node][i]<min){
               demoCost=G1[node][i];
               min=G1[node][i];
               minIndex=i;

           }
       }
       nd=minIndex;
       cost+=demoCost;
       return nd;

    }
     void findMinRoute(Long[][] tsp)
    {
        int sum = 0;
        int counter = 0;
        int j = 0, i = 0;
        Long min = Long.MAX_VALUE;
        List<Integer> visitedRouteList = new ArrayList<>();

        // Starting from the 0th indexed
        // city i.e., the first city
        visitedRouteList.add(0);
        //visitedRouteList.add(3);
        System.out.println(tsp[0].length);
        route = new int[tsp.length];

        // Traverse the adjacency
        // matrix tsp[][]
        while (i < tsp.length && j < tsp[i].length) {

            // Corner of the Matrix
            if (counter >= tsp[i].length - 1) {
                break;
            }

            // If this path is unvisited then
            // and if the cost is less then
            // update the cost
            if (j != i && !(visitedRouteList.contains(j))) {
                if (tsp[i][j] < min) {
                    min = tsp[i][j];
                    route[counter] = j + 1;

                }
            }
            j++;

            // Check all paths from the
            // ith indexed city
            if (j == tsp[i].length) {
                sum += min;
                min = Long.MAX_VALUE;
                visitedRouteList.add(route[counter] - 1);

                j = 0;
                i = route[counter] - 1;
                counter++;
            }
        }

        // Update the ending city in array
        // from city which was last visited
        i = route[counter - 1] - 1;

        /*for (j = 0; j < tsp.length; j++) {

            if ((i != j) && tsp[i][j] < min) {
                min = tsp[i][j];
                route[counter] = j + 1;
            }
        }*/
        sum += min;
        for(int k=0;k< route.length;k++){
            System.out.print("-->"+route[k]);
        }

            System.out.println("");
        for(int k=0;k<4;k++){
            System.out.print("-->"+visitedRouteList.get(k));
        }
        // Started from the node where
        // we finished as well.
        System.out.print("Minimum Cost is : ");
        System.out.println(sum);
    }
    private boolean acceptRoute(Long currentDistance, Long adjDistance,double Temp ){

        boolean shorterDistance=true;
        boolean acceptRouteFlag=false;
        Double P=1.0;// acceptance probability
        if (adjDistance>=currentDistance){
            P=Math.exp(-(adjDistance-currentDistance)/Temp);
            shorterDistance = false;}
            if(P>=Math.random())acceptRouteFlag=true;


        return acceptRouteFlag ;
    }
    public Route findRoute(Double Temp,Route currentRoute){
    Double rateOfCooling=0.05;

    Double minTemp=0.99;

    Route shortestRoute=new Route(currentRoute);
    Route adjRoute;
    while (Temp>minTemp){
        adjRoute=getAdjRoute(new Route(currentRoute));
        if (currentRoute.getDistance()<shortestRoute.getDistance())
            shortestRoute=new Route(currentRoute);
        if (acceptRoute(currentRoute.getDistance(),adjRoute.getDistance(),Temp))
            currentRoute=new Route(adjRoute);
                    Temp*=1-rateOfCooling;

            System.out.println(Arrays.toString(shortestRoute.route));
           // System.out.print(" ");

    }

    return shortestRoute;


    }
    public Route getAdjRoute(Route route){
        int x1=0,x2=0;
        while(x1==x2 || x1==0||x2==0||x1>=route.route.length-1||x2>=route.route.length-1){
            if(x1>=route.route.length-1||x1==0)
                x1=(int)(route.route.length*Math.random());
            else if(x2>=route.route.length-1||x2==0)
                x2=(int)(route.route.length*Math.random());
            else{
                x1=(int)(route.route.length*Math.random());
                x2=(int)(route.route.length*Math.random());
               }
            }
        int aux;
        Route route1=new Route(route);
        aux=route1.route[x1];
        route1.route[x1]=route1.route[x2];
        route1.route[x2]=aux;
        //  System.out.println(Arrays.toString(route1.route));


        return route1;



    }
    class Route{
        Route(int[] route1){
            this.route=route1.clone();
        }
        int[] route;
        Route(Route route1){
            this.route=route1.route.clone();
        }
        public Long getDistance(){
            Long distance=new Long(0);
            for(int i=0;i<route.length-1;i++){
                distance+=G1[route[i]][route[i+1]];
            }
            return distance;

        }
    }

}
 class LocationDuration{
   public  List<Location> route;
    public Long duration;
    LocationDuration(List <Location> route,Long duration){
        this.route=route;
        this.duration=duration;
    }
}