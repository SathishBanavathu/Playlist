package orj.acci.Playlist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String albumName;
    private String artistName;
    List<Song> songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList = new ArrayList<>();
    }

    public boolean findSong(String title)
    {
        for (Song song:songList) {
            if(title==song.title)
            {
                return true;
            }
        }
        return false;
    }


    public String addSong(String title,double duration)
    {
        //Check whether song is already present or not
        //if not add
        for (Song song :songList) {
            if(findSong(title)==true)
            {
                return "Song is already present";
            }
        }

        // I need to create song object and the song added to songList
        Song addsong = new Song(title,duration);
        songList.add(addsong);
        return "Song added successfully ";
    }

    public String addSongToPlaylist(int trackNo , LinkedList<Song> playlist)
    {
        int index =trackNo-1;
        if(index>=0&&index<=songList.size())
        {
            Song song = songList.get(index);
            playlist.add(song);
            return "Song added to playList ";
        }
        else {
            return "Invalid trackNo";
        }
    }


    public String addSongToPlaylist(String title , LinkedList<Song> playlist)
    {
        //If the song is present then i will add to playlist
        for (Song song:songList) {
            if(song.title.equals(title))
            {
                playlist.add(song);
                return "Song added successfully";
            }
        }
        return "Song doesn't exist";
    }

}
