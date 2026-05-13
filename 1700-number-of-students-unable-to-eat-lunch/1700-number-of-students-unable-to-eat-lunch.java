class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int count0=0;
        int count1=0;
        for(int i=0;i<students.length;i++){
            if(students[i]==0){
                count0++;
            }else{
                count1++;
            }
        }
        for(int i=0;i<sandwiches.length;i++){
            if(sandwiches[i]==0){
                if(count0==0){
                    break;
                }else{
                    count0--;
                }
            }else{
                if(sandwiches[i]==1){
                    if(count1==0){
                        break;
                    }else{
                        count1--;
                    }
                }
            }
        }
        return count0+count1;
    }
}