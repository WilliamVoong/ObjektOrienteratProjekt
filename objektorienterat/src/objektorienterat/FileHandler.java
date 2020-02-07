package src.objektorienterat;


import java.io.*;

public class FileHandler   {
    public static void Save_game(GUI_GAME game,String file_name) throws FileNotFoundException,IOException
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

    public static GUI_GAME load_game(String file_name)  throws FileNotFoundException,IOException,ClassNotFoundException
    {
        GUI_GAME my_pre_game;
        ObjectInputStream load_file=new ObjectInputStream(new FileInputStream(file_name));
        GUI_GAME test=(GUI_GAME)load_file.readObject();
            load_file.close();
            return test;
        }



    public static void Save_game_model(Game game,String file_name) throws FileNotFoundException,IOException
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

    public static Game load_game_model(String file_name)  throws FileNotFoundException,IOException,ClassNotFoundException
    {
        Game my_pre_game;
        ObjectInputStream load_file=new ObjectInputStream(new FileInputStream(file_name));
        Game test=(Game) load_file.readObject();
        load_file.close();
        return test;


    }
}


