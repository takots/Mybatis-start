import java.io.Reader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ts.maper.UserMaper;
import com.ts.pojo.Order;
import com.ts.pojo.User;

public class App {

	private static ApplicationContext ctx;

	static {
		ctx = new ClassPathXmlApplicationContext("config/applicationContext.xml");
	}

	public static void main(String[] args) {
		UserMaper userMaper = (UserMaper) ctx.getBean("userMaper");
		// 測試id=1的用戶查詢，可根據數據庫中的情況修改.
		User user = userMaper.getUserById(1);
		System.out.println("獲取用戶 ID=1 的用戶名：" + user.getUsername());

		// 得到文章列表測試
		System.out.println("得到用戶id為1的所有訂單列表:");
		System.out.println("=============================================");
		List<Order> orders = userMaper.getUserOrders(1);

		for (Order order : orders) {
			System.out.println("訂單號：" + order.getOrderNo() + "，訂單金額：" + order.getMoney());
		}
	}
}
