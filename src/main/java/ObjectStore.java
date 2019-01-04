/**
 * Created by chenxuehui on 2018/7/19
 */


import netscape.javascript.JSObject;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStore {
    private static final String TAG = "ObjectStore";

    public static Object readObject(String path) {
        ObjectInputStream stream = null;
        try {
            stream = new ObjectInputStream(new FileInputStream(path));
            return stream.readObject();
        } catch (Exception e) {
            System.out.println(TAG + "failed to read object from " + path + e);
        } finally {

        }
        return null;
    }

    public static boolean writeObject(String path, Serializable object) {
        ObjectOutputStream stream = null;
        try {
            stream = new ObjectOutputStream(new FileOutputStream(path));
            stream.writeObject(object);
            return true;
        } catch (Exception e) {
            System.out.println(TAG + "failed to write object to " + path + e);
        } finally {

        }
        return false;
    }

    public static class Serializer implements Serializable {

        public static final long serialVersionUID = 1L;
        public static final long serialVersionUID_ = 2L;

        public String mJson;
    }

    public static class Sub extends Serializer{
        public static final long serialVersionUID = 3L;

        public String a;
    }

    public static void main(String[] args) {
        double a = 13;
        System.out.println(a);
        JSONObject ob = new JSONObject();
        ob.put("vale", a);
        System.out.println(ob.toString());

        Serializer s1 = new Serializer();
        s1.mJson = "mJson";
        Sub s2 = new Sub();
        s2.mJson = "SubmJson";
        s2.a = "Suba";
        long l1 = Sub.serialVersionUID;
        long l2 = Sub.serialVersionUID_;
        long l3 = Serializer.serialVersionUID;
        long l4 = Serializer.serialVersionUID_;
        String path = "/Users/chenxuehui/Downloads/tmp/serializer.test";
        ObjectStore.writeObject(path, s2);
        Object o = ObjectStore.readObject(path);
        if (o instanceof Serializer && ((Serializer) o).mJson != null) {
            System.out.println(((Serializer) o).mJson);
        } else {
            System.out.println("not");
        }

    }
}
