package com.game.utils;

import com.game.levels.Level;
import com.game.levels.tiles.Tile;

import java.util.*;

public class PathFinder {


        private PathFinder(){

        }


        private static class TrieuseDeNoeud implements Comparator<Node>{


            @Override
            public int compare(Node o1, Node o2) {
                 if(o1.getfCost() >  o2.getfCost()){
                      return 1;
                }
                 else if(o2.getfCost() > o1.getfCost()){
                     return -1;
                 }
                return 0;
            }
        }

        public static List<Node> findPath(Level level, Vector2i start, Vector2i goal){

                List<Node> openList = new ArrayList<Node>();
                List<Node> closedList = new ArrayList<Node>();

                Node current = new Node(null,start,0,getDistance(start,goal));

                openList.add(current);

                // tantque il reste des noeuds non visités
                while(openList.size() > 0){

                    // trie les noeuds du moins couteux au plus couteux
                    Collections.sort(openList,new TrieuseDeNoeud());

                    // on récupère le noeud le moins couteux
                    current = openList.get(0);

                    //current egale a goal alors c'est gagné !
                    if(current.getPosition().equals(goal)){
                        List<Node> path = new ArrayList<Node>();
                            while(current.getParent() != null){
                                 path.add(current);
                                 current = current.getParent();
                            }

                            openList.clear();
                            closedList.clear();

                            return path;
                    }



                    openList.remove(current);
                    closedList.add(current);


                    // exploration des voisins

                    for(int i=0;i<9;i++){
                        if(i == 4) continue;

                        int x = current.getPosition().x;
                        int y = current.getPosition().y;

                        int xi = (i % 3) - 1;
                        int yi = (i / 3) - 1;

                       Tile tile = level.getTileByColor(x + xi , y + yi);

                       if(tile == null) continue;
                       if(tile.isSolid()) continue;;

                       Vector2i currently_checking_position = new Vector2i(x + xi , y + yi);

                       double gCost = current.getgCost() + getDistance(current.getPosition() , currently_checking_position);
                       double hCost = getDistance(current.getPosition() , goal);


                       Node node = new Node(current,currently_checking_position,gCost,hCost);

                        // si c'est vrai alors le noeud est déja visité au passe au suivant directement
                        if(isInVect(closedList,currently_checking_position)) continue;

                        // si le noeud n'est pas encore visité alors c'est un noeud valide
                        if(!(isInVect(openList,currently_checking_position))) openList.add(node);
                    }



                }
            closedList.clear();
            return null;
        }

        public static boolean isInVect(List<Node> nodes,Vector2i position){
            for(int i=0;i<nodes.size();i++){
                 if(nodes.get(i).getPosition().equals(position)){
                     return true;
                 }
            }
            return false;
        }


        public static double getDistance(Vector2i start,Vector2i end){
            double dx = start.x  - end.x;
            double dy = start.y  - end.y;
            return Math.sqrt(dx * dx + dy * dy);
        }


}
