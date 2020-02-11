package src.objektorienterat;


import java.io.*;

public class FileHandler implements Serializable {
    public static void Save_game(FileHandlerInterface game, String file_name,String playername) throws FileNotFoundException, IOException {
        File file = new File(file_name);
        AppendableObjectOutputStream save_file;
        if (file.exists()) {
            save_file = new AppendableObjectOutputStream(new FileOutputStream(file,true));

        } else {
            save_file = new AppendableObjectOutputStream(new FileOutputStream(file_name));

        }

        save_file.writeUTF(playername);
        save_file.writeObject(game);
        save_file.flush();
        save_file.close();


    }

    public static FileHandlerInterface load_game(String file_name,String playername) throws FileNotFoundException, IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(file_name);
        AppendableObjectInputStream load_file = new AppendableObjectInputStream(fis);
        while(fis.available()>0)
        {
            if(load_file.readUTF().equals(playername)) {
                FileHandlerInterface test = (FileHandlerInterface) load_file.readObject();
                load_file.close();
                return test;
            }
            else
                load_file.readObject();

        }
        return null;

    }






    public static void print() throws IOException, ClassNotFoundException {
        AppendableObjectInputStream file= new AppendableObjectInputStream(new FileInputStream("Save_model9"));
        for(int i=0;i<3;i++)
        {


            System.out.println(file.readObject());
            file.readObject();

        }
    }
}


/*  This is for saving game Model
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


 */

