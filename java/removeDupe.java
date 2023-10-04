public class removeDupe{


	public static boolean isSorted(int[] nums){
		int last_num = -2147483648;
		for(int i = 0 ; i < nums.length ; i++){
			if(nums[i] < last_num){
				return false;
			}
			last_num = nums[i];
		}
		return true;
	}


	//returns 0 if its not sorted
	public static int remove_duplicates(int[] nums){
		print_array(nums);

		if(nums.length == 0){
			return 0;
		}
		if(!isSorted(nums)){
			return 0;
		}
		int k = 1;
		int current_num = nums[0];

		for(int i = 1 ; i < nums.length ; i++){
			if(nums[i] > current_num){
				current_num = nums[i];
				nums[k] = nums[i];
				k += 1;
			}
			if(k-1 != i){
				nums[i] = 0;
			}
		}
		print_array(nums);
		return k;
	}


	public static void print_array(int[] nums){
		for(int i = 0 ; i < nums.length ; i++){
			System.out.print(nums[i] + ", ");
		}
		System.out.print("\n");
	}

	public static void do_test(int[] nums, int expected_val){
		System.out.println("-------------------------");

		int actual_val = remove_duplicates(nums);
		System.out.println("Expected: " + expected_val);
		System.out.println("Actual: " + actual_val);
		if(expected_val == actual_val){
			System.out.println("Pass");
		}
		else{
			System.out.println("Fail");
		}
		System.out.println("-------------------------");
	}

	public static void test_remove_duplicates(){
		//nothing
		int[] nums0 = new int[0];
		do_test(nums0, 0);

		//5 numbers 0 duplicates
		int[] nums1 = {0, 1, 2, 3, 4};
		do_test(nums1, 5);

		//1 number 1 duplicate
		int[] nums2 = {0, 0};
		do_test(nums2, 1);

		//1 number lots of duplicates
		int[] nums3 = {0,0,0,0,0,0,0,0};
		do_test(nums3, 1);

		//lots of numbers lots of duplicates
		int[] nums4 = {0,0,2,2,3,4,5,234,600,600};
		do_test(nums4, 7);

		//negative numbers
		int[] nums5 = {-33,-22,-22,-5,0,5,22,23,23};
		do_test(nums5, 7);

		//bad input not sorted
		int[] nums6 = {10,9,8,7,6};
		do_test(nums6, 0);
		
	}

	public static void main(String[] args){
		test_remove_duplicates();
	}
}