class Solution {
public:
    int subtractProductAndSum(int n) {
        if(n==0){
            return 0;
        }
        vector<int> vect;
        while(n != 0){
            int a = n%10;
            n = n/10;
            vect.push_back(a);
        }
        int product = 1;
        int sum = 0;
        for(int i = 0; i < vect.size(); i++){
            sum+= vect[i];
            product*= vect[i];
        }
        return product - sum;
    }
};