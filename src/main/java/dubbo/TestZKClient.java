package dubbo;

import java.io.IOException;
import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.ZkClient;

public class TestZKClient {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ZkClient client = new ZkClient("192.168.31.226:2181");
		// client.createPersistent("/parent1", "1212");
		client.subscribeChildChanges("/parent", new IZkChildListener() {

			// @Override
			public void handleChildChange(String arg0, List<String> arg1) throws Exception {
				System.out.println("变化了");
				System.out.println(arg1);
			}
		});
		System.out.println("运行完成");
		System.in.read();
		client.close();
	}
}
