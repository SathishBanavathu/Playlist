package orj.acci.Playlist;

import java.util.*;

public class Main {
    public static List<Album> albums = new ArrayList<>();
    public static void main(String[] args) {
            Album album = new Album("Old Is Gold","Chitra");
// first album
            album.addSong("Sri Rasthu",4.0);
            album.addSong("Swathilo Muthyamatha",3.90);
            album.addSong("Bangaru Kodi Petta",4.20);
            albums.add(album);

            album = new Album("Nwe Songs","DSP");

            album.addSong("Boss Party",4.0);
            album.addSong("Saami Saami",3.90);
            album.addSong("Srivalli",4.20);
            albums.add(album);

            LinkedList<Song> playlist_1 = new LinkedList<>();
// second album
            albums.get(0).addSongToPlaylist("Sri Rasthu",playlist_1);
            albums.get(0).addSongToPlaylist("Bangaru Kodi Petta     ",playlist_1);
            albums.get(1).addSongToPlaylist("Boss Party",playlist_1);
            albums.get(1).addSongToPlaylist("Saami Saami",playlist_1);


            play(playlist_1);

        }


        public static void play(LinkedList<Song> playList)
        {
            Scanner sc = new Scanner(System.in);
            ListIterator<Song> listIterator = playList.listIterator();
            // Validation checks
            if(playList.size()==0)
            {
                return ;
            }
            printMenu();
            System.out.println("Now playing"+listIterator.next().toString());
            boolean forward = true;

            boolean quit =false;
            while(quit==false)
            {

                int choice = sc.nextInt();

                switch(choice)
                {
                    case 1 :
                        //To play the next song
                        if(forward==false)
                        {
                            listIterator.next();
                            forward=true;
                        }
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now playing"+listIterator.next().toString());
                        }
                        else
                        {
                            System.out.println("We are at Last song");
                        }
                        break;
                    //To play the previous song
                    case 2 :
                        if(forward==true)
                        {
                            listIterator.previous();
                            forward=false;
                        }
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Now playing"+listIterator.previous().toString());
                        }
                        else
                        {
                            System.out.println("we are at first song");
                        }
                        break;
                    //To relplay the Current song
                    case 3 :
                        if(forward==true)
                        {
                            // on RHS Side
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward=false;
                        }
                        else {
                            //on LHS Side
                            System.out.println("Now playing"+listIterator.next().toString());
                            forward=true;
                        }


                        break;
                    //To print all songs in playlist
                    case 4 :
                        for (Song song:playList)
                        {
                            System.out.println(song.toString());
                        }
                        break;
                }
            }

        }

        public static void printMenu() {
            System.out.println("Available options");
            System.out.println("0 to exict \n" +
                    "1 - To play next song\n" +
                    "2 - To play previous song\n" +
                    "3 - To replay the current song\n" +
                    "4 - List of all songs\n");
        }
}