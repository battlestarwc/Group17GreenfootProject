package dijkstra;

public class Vertex implements Comparable<Vertex> {
    private final String name;
    private final Integer id;
    private String lastVertex = null;
    private Integer lastId = new Integer(-1);
    private Double costFromLast = new Double(-1);
    private Double totalCost = new Double(-1);

    public Vertex(String name, int id) {
        this.name = name;
        this.id = new Integer(id);
    }

    public Vertex(String name) {
        this.name = name;
        this.id = new Integer(-1);
    }

    public Vertex(int id) {
        this.name = null;
        this.id = new Integer(id);
    }

    //copy constructor
    public Vertex(Vertex in) {
        this.name = in.getName();
        this.id = in.getId();
        this.lastVertex = in.getLastVertex();
        this.lastId = in.getLastId();
        this.costFromLast = in.getCost();
        this.totalCost = in.getTotalCost();
    }

    public void setLastVertex(Vertex last, double cost) {
        this.lastVertex = last.getName();
        this.lastId = last.getId();
        this.costFromLast = new Double(cost);
        this.totalCost = new Double(this.costFromLast + last.getTotalCost());
    }

    public void setLastVertex(String last, double cost) {
        this.lastVertex = last;
        this.costFromLast = new Double(cost);
        this.totalCost = new Double(cost);
    }

    public void setLastVertex(int last, double cost) {
        this.lastId = last;
        this.costFromLast = new Double(cost);
        this.totalCost = new Double(cost);
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return costFromLast.doubleValue();
    }

    public int getId() {
        return id.intValue();
    }

    public int getLastId() {
        return lastId.intValue();
    }

    public String getLastVertex() {
        return lastVertex;
    }

    public double getTotalCost() {
        return totalCost.doubleValue();
    }

    @Override
    public int compareTo(Vertex o) {
        //check for unset shit
        boolean check1 = this.totalCost.doubleValue() < 0 && o.getTotalCost() < 0;
        boolean check2 = this.costFromLast.doubleValue() < 0 && o.getCost() < 0;
        //check for single set
        boolean check3 = this.costFromLast.doubleValue() < 0 && this.totalCost.doubleValue() < 0 && o.getCost() > 0 && o.getTotalCost() > 0;
        boolean check4 = this.costFromLast.doubleValue() > 0 && this.totalCost.doubleValue() > 0 && o.getCost() < 0 && o.getTotalCost() < 0;

        //they are essentially the same at this point
        if (check1 || check2) {
            return 0;
        }

        //one is unset, so return less than the set one
        if (check3) {
            return -1;
        }
        if (check4) {
            return 1;
        }

        //now actually check for equivalence
        int result = 0; //assume equal till proven otherwise (Justice)

        result = (this.totalCost - o.getTotalCost() > 0) ? 1 : -1;

        //check for equivalence
        if (result == -1 && this.totalCost.equals(new Double(o.getTotalCost()))) {
            result = 0;
        }

        return result;

    }

    public boolean idEquals(Object obj) {
        if( obj instanceof Vertex) {
            if(((Vertex) obj).getName() == null || this.getName() == null) {
                if(((Vertex) obj).getId() == this.getId()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if(((Vertex) obj).getName().equals(this.getName())) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if( obj instanceof Vertex) {
            boolean nameCheck = false;
            boolean lastCheck = false;
            boolean costCheck = false;

            if(this.name == null && ((Vertex) obj).getName() == null) {
                if(this.id == ((Vertex) obj).getId()) {
                    nameCheck = true;
                }
            } else {
                if(this.name.equals(((Vertex) obj).getName()) && this.id == ((Vertex) obj).getId()) {
                    nameCheck = true;
                }
            }

            if(this.totalCost.equals(((Vertex) obj).getTotalCost()) && this.costFromLast.equals(((Vertex) obj).getCost())) {
                costCheck = true;
            }

            if(this.lastVertex == null && ((Vertex) obj).lastVertex == null) {
                if(this.lastId.equals(((Vertex) obj).getLastId())) {
                    lastCheck = true;
                }
            } else {
                if(this.lastVertex.equals(((Vertex) obj).lastVertex)) {
                    lastCheck = true;
                }
            }

            result = costCheck && nameCheck && lastCheck;
        }
        return result;
    }
}
