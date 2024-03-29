import java.util.Random;

import dataview.models.Dataview;
import dataview.models.InputPort;
import dataview.models.OutputPort;
import dataview.models.Port;
import dataview.models.Task;


public class mConcatFit extends Task{
	int num_mDiffFit = 8;
	public mConcatFit()
	{
		super("mConcatFit", "e difference images are then fitted using a least squares algorithm");
		
		ins = new InputPort[num_mDiffFit];
		outs = new OutputPort[1];
		
		Dataview.debugger.logObjectValue("num_mDiffFit", num_mDiffFit);
		
		for(int i = 0; i < num_mDiffFit; i++){
			ins[i] = new InputPort("in"+i, Port.DATAVIEW_String, "");
		}
		outs[0] = new OutputPort("out0", Port.DATAVIEW_String, "");				
	}
	public void run() {
		// TODO Auto-generated method stub
//		for(int i = 0; i < num_mDiffFit; i++){
//			ins[i].read();
//		}
		Random rand = new Random(1000);
		int totalNumber = 300000;
		/*
		int arr[] = new int[totalNumber];
		int arr1[] = new int[totalNumber];
		for (int i = 0; i < totalNumber; i++) {
			arr[i] = rand.nextInt(Integer.MAX_VALUE) + 1;
			arr1[i] = rand.nextInt(Integer.MAX_VALUE) + 1;
		}
		
		int arr2[] = new int[totalNumber];
		for(int i = 0; i < totalNumber; i++){
			arr2[i] = arr[i] + arr1[i]; 
		}
		*/
		
		int arr[] = new int[totalNumber];
		for (int i = 0; i < totalNumber; i++) {
			arr[i] = rand.nextInt(Integer.MAX_VALUE) + 1;
		}
		int temp;
		for (int i = 0; i < totalNumber; i++) {
			for (int j = 0; j < totalNumber; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		int arr1[] = new int[totalNumber];
		for (int i = 0; i < totalNumber; i++) {
			arr1[i] = rand.nextInt(Integer.MAX_VALUE) + 1;
		}
		int temp1;
		for (int i = 0; i < totalNumber; i++) {
			for (int j = 0; j < totalNumber; j++) {
				if (arr1[i] > arr1[j]) {
					temp1 = arr[i];
					arr1[i] = arr1[j];
					arr1[j] = temp1;
				}
			}
		}
		//outs[0].write(toString(arr));
	}
	private static String toString(int[] array) {
	      StringBuilder sb = new StringBuilder();
	      for (int i = 0; i < array.length; i++) {
	         sb.append(array[i]);
	         sb.append(" ");
	      }
	      return sb.toString();
	   }
}
