package 日常练习.数据结构练习.Set.HashSet;

public class HashSetDemo2 {
    public static void main(String[] args) {
        Student s1 = new Student("xiaozhi",23);
        Student s2 = new Student("xiaomei",22);

        //在Object类中是根据对象的地震计算出来的哈希值
        System.out.println(s1.hashCode());//460141958

        //不同对象的哈希值不一样
        System.out.println(s2.hashCode());//1163157884
        System.out.println(s2.hashCode());//1163157884
    }
}
