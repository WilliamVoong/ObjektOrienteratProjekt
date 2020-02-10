package src.objektorienterat;


import java.io.*;

public class FileHandler implements Serializable   {
    public static void Save_game(GameView game, String file_name) throws FileNotFoundException,IOException
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

    public static GameView load_game(String file_name)  throws FileNotFoundException,IOException,ClassNotFoundException
    {
        GameView my_pre_game;
        ObjectInputStream load_file=new ObjectInputStream(new FileInputStream(file_name));
        GameView test=(GameView)load_file.readObject();
            load_file.close();
            return test;


        }



    public static void Save_game_model(GameModel gameModel, String file_name) throws FileNotFoundException,IOException
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

        save_file.writeObject(gameModel);
        save_file.close();

    }

    public static GameModel load_game_model(String file_name)  throws FileNotFoundException,IOException,ClassNotFoundException
    {
        GameModel my_pre_game;
        ObjectInputStream load_file=new ObjectInputStream(new FileInputStream(file_name));
        GameModel test=(GameModel) load_file.readObject();
        load_file.close();
        return test;


    }
}


