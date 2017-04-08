/*  Main Class  */

public class Main {

    public static void main(String[] args) {

    }
}


/*  Song Class  */

public class Song {

    //  Fields for Song Class
    private String title;
    private double duration;

    //  Constructor
    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    //  Getter
    public String getTitle() {
        return title;
    }

    //  Method to print title and duration as a string
    public String toString() {
        return this.title + ": " + this.duration;
    }
}


/*  Album Class  */

public class Album {

    //  Fields for Album Class
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    //  Constructor
    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    //  Method to add song to album
    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    //  Method to search album for song
    private Song findSong(String title) {
        for (Song checkedSong: this.songs) {        //  This is Java's 'for each'.  Creates a checkedSong variable for every song in the arraylist
            if (checkedSong.getTitle().equals(title)) {
                return checkedSong;
            }
        }
        return null;
    }

    //  Method to add songs from album to playlist
    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;
        if ((index > 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    //  Overloaded method, allowing to add by title
    public boolean addToPlaylist(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song '" + title + "' is not in this album");
        return false;
    }
}
