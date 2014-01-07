package nb.largefactory.structure.calculations;

public class Imput {
    String nameOfMaterial;
    int numberOfItems;
        Imput(String name, int number){
            nameOfMaterial = name;
            numberOfItems = number;
        }
        public String getNameOfMaterial() {
            return nameOfMaterial;
        }
        public void setNameOfMaterial(String nameOfMaterial) {
            this.nameOfMaterial = nameOfMaterial;
        }
        public int getNumberOfItems() {
            return numberOfItems;
        }
        public void setNumberOfItems(int numberOfItems) {
            this.numberOfItems = numberOfItems;
        }
        
        
}
