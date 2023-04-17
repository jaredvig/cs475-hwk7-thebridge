/**
 * Runs all threads
 */
public class BridgeRunner {

	public static void main(String[] args) {

		// TODO - check command line inputs
		if(args.length!=2){
			System.out.println("Please only have 2 arguments for this method :)!");
			System.exit(1);
		}
		int[] intArgs = new int[2];
		intArgs[0] = Integer.parseInt(args[0]);
		intArgs[1] = Integer.parseInt(args[1]);
		if(intArgs[0]<1||intArgs[1]<1){
			System.out.println("Please use non-negative integers for your inputs :)!");
			System.exit(1);
		}
		// TODO - instantiate the bridge
		OneLaneBridge bridge = new OneLaneBridge ();
		bridge.setLimit(intArgs[0]);
		// TODO - allocate space for threads
		Thread[] cars = new Thread[intArgs[1]];
			for(int i = 0; i<intArgs[1]; i++){
				cars[i] = new Thread(new Car(i, bridge));
			}
		// TODO - start then join the threads
		for(int i = 0; i<cars.length;i++){
			cars[i].start();
		}
		// while(cars.length>0||bridge.size>0){
		// 	if(bridge.size<intArgs[0]){
		// 	for(int i = 0; i<cars.length i++){
		// 		if(cars[i].getDirection==bridge.direction){
					
		// 		}
		// 	}
		// 	}
		// 	System.out.println()
		// 	if(bridge.size()==0){
		// 		bridge.direction = !bridge.direction
		// 	}
		// }
		for(int i = 0; i<cars.length;i++){
			try{
				cars[i].join();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			}
			System.out.println("All cars have crossed!!");
		}
		
}