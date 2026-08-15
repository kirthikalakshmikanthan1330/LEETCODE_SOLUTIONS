class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int [] result=new int[k];
        ArrayList<Integer> keys=new ArrayList<>(map.keySet());
        for(int i=0;i<k;i++){
            int maxfrequency=0;
            int maxelement=0;
            for(int j=0;j<keys.size();j++){
                int num=keys.get(j);
                if(map.containsKey(num)&&map.get(num)>maxfrequency){
                    maxfrequency=map.get(num);
                    maxelement=num;
                }
            }
            result[i]=maxelement;
            map.remove(maxelement);
        }
        return result;
    }
}