package src.objektorienterat;


import java.io.*;

public class FileHandler {
    public static void Save_game(Game game, String file_name) throws Exception
    {
        File file =new File(file_name);
        ObjectOutputStream save_file;
        if(file.exists())
        {
             save_file=new ObjectOutputStream(new FileOutputStream(file));

        }

        else
        {
             save_file=new ObjectOutputStream(new FileOutputStream(file_name));

        }

        save_file.writeObject(game);
        save_file.close();

    }

    public static void load_game(String file_name) throws Exception
    {
        Game my_pre_game;
        ObjectInputStream load_file=new ObjectInputStream(new FileInputStream(file_name));
       my_pre_game=(Game)load_file.readObject();
       for(int i =0;i<my_pre_game.getMarks().length;i++)
       {
           System.out.println(my_pre_game.getMark(new Coordinate(0,i)));
       }



    }

}
