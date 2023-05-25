import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ts.mybatis.models.User;
import com.ts.mybatis.dao.IUser;

public class HelloWorld {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader = Resources.getResourceAsReader("config/Configure.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSessionFactory.getConfiguration().addMapper(IUser.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUser iuser = session.getMapper(IUser.class);
            User user = iuser.getUserByID(1);
            String userInfo = "名字："+user.getName()+", 所屬部門："+user.getDept()+", 主頁："+user.getWebsite();
            System.out.println(userInfo);
        } finally {
            session.close();
        }
    }

}