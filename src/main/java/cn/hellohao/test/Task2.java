package cn.hellohao.test;import com.alibaba.fastjson.JSONObject;import java.io.BufferedReader;import java.io.IOException;import java.io.InputStreamReader;import java.net.MalformedURLException;import java.net.URL;import java.net.URLConnection;import java.util.*;/** * 于第一种方式相比，优势 1>当启动和去取消任务时可以控制 2>第一次执行任务时可以指定你想要的delay时间 * <p> * 在实现时，Timer类可以调度任务，TimerTask则是通过在run()方法里实现具体任务。 Timer实例可以调度多任务，它是线程安全的。 * 当Timer的构造器被调用时，它创建了一个线程，这个线程可以用来调度任务。 下面是代码： * * @author GT */public class Task2 {    public static void main(String[] args) {        TimerTask task = new TimerTask() {            Map<String, Integer> map = new HashMap<String, Integer>();            @Override            public void run() {                // task to run goes here                  //System.out.println("Hello !!!");                String url = "http://ip.360.cn/IPShare/info";                String json = loadJSON(url);                //System.out.println(json);                JSONObject pa = JSONObject.parseObject(json);                //System.out.println(pa.getString("ip"));                map.put(pa.getString("ip"), 5);                List<Map.Entry<Object, Object>> li = getKeyBySameValue(map);                Integer count = 0;                for (int i = 0; i < li.size(); i++) {                    System.out.println(li.get(i).getKey());                    Integer a = Integer.parseInt(String.valueOf(li.get(i).getKey()));                    count = count + a;                    if (count > 30) {                        System.out.println("您已经被限制！");                    }                }            }        };        Timer timer = new Timer();        long delay = 0;        long intevalPeriod = 5 * 1000;        // schedules the task to be run in an interval          timer.scheduleAtFixedRate(task, delay, intevalPeriod);    } // end of main    //获取本机ip    public static String loadJSON(String url) {        StringBuilder json = new StringBuilder();        try {            URL oracle = new URL(url);            URLConnection yc = oracle.openConnection();            BufferedReader in = new BufferedReader(new InputStreamReader(                    yc.getInputStream(), "utf-8"));//防止乱码            String inputLine = null;            while ((inputLine = in.readLine()) != null) {                json.append(inputLine);            }            in.close();        } catch (MalformedURLException e) {            e.printStackTrace();        } catch (IOException e) {            e.printStackTrace();        }        return json.toString();    }    public static List<Map.Entry<Object, Object>> getKeyBySameValue(Map map) {        Map values = new HashMap();        List list;        Iterator iterator = map.keySet().iterator();        while (iterator.hasNext()) {            Object key = iterator.next();            Object value = map.get(key);            if (map.containsValue(value)) {                if (values.containsKey(value)) {                    list = (List) values.get(value);                } else {                    list = new ArrayList();                }                list.add(key);                values.put(value, list);            }        }        iterator = values.keySet().iterator();        Map<Object, Object> newMap = new HashMap<>();        while (iterator.hasNext()) {            Object value = iterator.next();            List result = (List) values.get(value);            if (result.size() > 1) {                System.out.println("value :" + value + "  -> keys:"                        + result.toString());            }            newMap.put(value, result.toString());        }        List<Map.Entry<Object, Object>> returnList = new ArrayList<>(newMap.entrySet());        return returnList;    }}