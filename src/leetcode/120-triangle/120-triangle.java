class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        for(int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                
                int minCost = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1))
                                + triangle.get(i).get(j);
                //reusing the already given List<List>> so we take no extra space with same time complexity
				triangle.get(i).set(j, minCost);
            }
        }
        
        return triangle.get(0).get(0);
    }
}