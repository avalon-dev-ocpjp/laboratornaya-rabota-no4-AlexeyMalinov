package ru.avalon.java.dev.ocpjp.labs.models;


class CommodityImpl implements Commodity, Cloneable{

    private String code;
    private String vendorCode;
    private String name;
    private double price;
    private int residue;
    

    static class CommodityBuilderImpl implements CommodityBuilder{

        private final CommodityImpl dummy = new CommodityImpl();

        CommodityBuilderImpl() {
        }
        
        @Override
        public CommodityBuilder code(String code) {
            dummy.code = code;
            return this;
        }

        @Override
        public CommodityBuilder vendorCode(String vendorCode) {
            dummy.vendorCode = vendorCode;
            return this;
        }

        @Override
        public CommodityBuilder name(String name) {
            dummy.name = name;
            return this;
        }

        @Override
        public CommodityBuilder price(double price) {
            dummy.price = price;
            return this;
        }

        @Override
        public CommodityBuilder residue(int residue) {
            dummy.residue = residue;
            return this;
        }

        @Override
        public CommodityImpl build() {
            return (CommodityImpl) dummy.clone();
        }
    
    }
    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getVendorCode() {
        return vendorCode;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public int getResidue() {
        return residue;
    }

    @Override
    protected Object clone(){
        try {
                return (CommodityImpl) super.clone();
            } catch (CloneNotSupportedException ex) {
                throw new IllegalStateException(ex);
            }
    }
    
    
}
