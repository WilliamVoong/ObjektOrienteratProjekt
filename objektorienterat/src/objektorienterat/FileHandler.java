package src.objektorienterat;


import java.io.*;


public class FileHandler   {
    GameView gameview;
    GameModel gamemodel;

    public FileHandler(GameModel gamemodel,GameView gameview)
    {
        this.gamemodel=gamemodel;
        this.gameview=gameview;

    }
    private   void Save_game(GameModel game, String file_name,Player player)  {

        try {
            File file = new File(file_name);
            AppendableObjectOutputStream save_file;
            if (file.exists()) {
                save_file = new AppendableObjectOutputStream(new FileOutputStream(file, true));

            } else {
                save_file = new AppendableObjectOutputStream(new FileOutputStream(file_name));

            }
            save_file.writeUTF(player.getUsername());
            save_file.writeObject(game);
            save_file.flush();
            save_file.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found Error");
        } catch (IOException e) {
            System.out.println("Error in Writing to the File");
        }

    }

    private GameModel load_game(String file_name,Player player) {
        try {
            FileInputStream fis = new FileInputStream(file_name);
            AppendableObjectInputStream load_file = new AppendableObjectInputStream(fis);
            GameModel test=null;
            while(fis.available()>0)
            {
                if(load_file.readUTF().equals(player.getUsername())) {
                    test = (GameModel) load_file.readObject();
                }
                else
                    load_file.readObject();
            }

            load_file.close();
            return test;


        }catch (FileNotFoundException e)
        {
            System.out.println("File Not Found Exeption");
        }
        catch (IOException e)
        {
            System.out.println("error in reading or writing the file ");


        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class Error . ");
        }

       return null;
    }

    public void setGamemodel(GameModel gamemodel)
    {
        this.gamemodel=gamemodel;

    }

    public void Save(Player player)
    {
        //Save_game(gameview,"Save_Gui22",player);
        Save_game(gamemodel,"Save_model34",player);

    }

    public GameModel Load(Player player)
    {
        //gameview=load_game("Save_Gui22",player);
       gamemodel=load_game("Save_model34",player);
      return gamemodel;


    }

}

/*  This is for saving game Model
    public static void Save_game_model(GameModel gameModel, String file_name) throws FileNotFoundException,IOException
=======
    public static void Save_game_model(GameModel game, String file_name) throws FileNotFoundException,IOException
>>>>>>> 904269f59fe1b30628cd8eacbde385a6e95670f6
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

