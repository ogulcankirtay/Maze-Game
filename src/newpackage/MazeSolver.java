/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.*;

public class MazeSolver {

    public static char duvar = '#';
    public static char baslangic = 's';
    public static char bitis = 'e';
    public static char emptyChar = '.';
    public static char dikeyYol = '|';
    public static char yatayYol = '-';

    private static int[] dC = {1, 0, -1, 0};
    private static int[] dR = {0, 1, 0, -1};

    public static ArrayList<Point> dijkstra(char[][] maze, Point baslangic, Point bitis) {
        HashMap<Point, Integer> dist = new HashMap<Point, Integer>();
        dist.put(baslangic, 0);

        HashMap<Point, Point> prev = new HashMap<Point, Point>();
        prev.put(baslangic, null);

        PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (!dist.containsKey(p1)) {
                    dist.put(p1, Integer.MAX_VALUE);
                }

                if (!dist.containsKey(p2)) {
                    dist.put(p2, Integer.MAX_VALUE);
                }

                return dist.get(p1) - dist.get(p2);
            }
        });
        if (baslangic != null) {

            queue.offer(baslangic);
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (dist.get(p) == Integer.MAX_VALUE) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                Point next = new Point(p.a + dR[i], p.b + dC[i]);

                if (!dist.containsKey(next)) {
                    dist.put(next, Integer.MAX_VALUE);
                }

                if (next.disardakiNokta(maze[0].length, maze.length) || maze[next.a][next.b] == duvar) {
                    continue;
                }

                if (dist.get(p) + p.mesafe(next) < dist.get(next)) {
                    dist.put(next, dist.get(p) + p.mesafe(next));

                    if (!prev.containsKey(next)) {
                        queue.offer(next);
                    }

                    prev.put(next, p);
                }
            }
        }

        ArrayList<Point> sonuc = new ArrayList<Point>();
        Point iter = bitis;
        while (iter != null) {
            sonuc.add(iter);
            iter = prev.get(iter);
        }

        Collections.reverse(sonuc);

        return sonuc.size() < 2 ? null : sonuc;
    }

}
