package 日常练习.高级部分.XML;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XmlParse {
    public static void main(String[] args) throws DocumentException {
        //1.获取一个解析器对象
        SAXReader saxReader = new SAXReader();
        //2.利用解析器把XML文件加载到内存中，并返回一个文档对象
        Document document = saxReader.read(new File("src\\日常练习\\高级部分\\XML\\xml\\student.xml"));
        //3.获取根标签
        Element rootElement = document.getRootElement();
        //4.通过根标签来获取student标签
        //elements():可以获取调用者所有的子标签，会把这些子标签放到一个集合中返回
       // List list = rootElement.elements();
        //elements("标签名")：可以获取调用者所有的指定的子标签，会把这些子标签放到一个集合中返回
        List<Element> studentElements = rootElement.elements("student");

        //用来装学生对象
        ArrayList<Student> list = new ArrayList<>();
        //5.遍历集合，得到每一个student标签
        for (Element element : studentElements) {
            //element依次表示每一个student标签

            //获取id这个属性
            Attribute attribute = element.attribute("id");
            //获取id的属性值
            String id = attribute.getValue();

            //获取name标签
            //element("标签名")：获取调用者指定的子标签
            Element nameElement = element.element("name");
            //获取name这个标签的标签体内容
            String name = nameElement.getText();

            //获取age标签
            Element ageElement = element.element("age");
            //获取age这个标签的标签体内容
            String age = ageElement.getText();

//            System.out.println(id);
//            System.out.println(name);
//            System.out.println(age);
            Student s = new Student(id,name,Integer.parseInt(age));
            list.add(s);
        }
        //遍历操作
        for (Student student : list) {
            System.out.println(student);
        }
    }
}
