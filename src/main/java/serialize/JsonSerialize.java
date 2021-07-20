package serialize;

import com.google.gson.Gson;
import model.Thinks;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonSerialize {

    public static void serialize(Thinks thinks, String path) throws IOException {
        Gson gson = new Gson();
        File file = new File(path);
        FileWriter fl = new FileWriter(file);
        fl.write(gson.toJson(thinks));
        System.out.println("Generated: " + file.getPath());
        fl.close();
    }

    public static Thinks deserialize(String path) throws IOException {
        return new Gson().fromJson(new FileReader(path), Thinks.class);
    }
}
