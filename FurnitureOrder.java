package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    private Map<Furniture, Integer> furnitureMap = null;
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
    	furnitureMap = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
    	if (furnitureMap.containsKey(type)) {
    		furnitureMap.put(type, furnitureMap.get(type).intValue() + furnitureCount);
    	} else {
    		furnitureMap.put(type, furnitureCount);
    	}
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return (HashMap<Furniture, Integer>) furnitureMap;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
    	float totalCost = 0.0f;
    	for (Map.Entry<Furniture, Integer> furnEntry :furnitureMap.entrySet()) {
    		totalCost = totalCost + (furnEntry.getValue() * furnEntry.getKey().cost()); 
    	}
    	return totalCost;
        //return -1.0f;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
    	if (furnitureMap.containsKey(type)) {
    		return furnitureMap.get(type);
    	}
        return 0;
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
    	if (furnitureMap.containsKey(type)) {
    		return furnitureMap.get(type) * type.cost();
    	}
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        return furnitureMap.values().stream().mapToInt(Integer::intValue).sum();
    }
}