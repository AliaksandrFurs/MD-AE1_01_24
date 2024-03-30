package Dataproviders;

import org.testng.annotations.DataProvider;

public class ArithmeticalDataProvider {

    @DataProvider(name = "longbasicsum", parallel = true)
    public Object [][] getLongBasicSumValues(){
        return new Object [][] {
                {0,1,1},
                {1,0,1},
                {1,1,2},
                {-1,-1, -2},
                {-1, 1, 0}
        };
    }

    @DataProvider(name = "longboundaryvaluessum", parallel = true)
    public Object [][] getLongBoundarySumValues(){
        return new Object [][]{
                {Long.MAX_VALUE,0, Long.MAX_VALUE},
                {0, Long.MAX_VALUE, Long.MAX_VALUE},
                {0,Long.MIN_VALUE, Long.MIN_VALUE},
                {Long.MIN_VALUE,0, Long.MIN_VALUE},
        };
    }

    @DataProvider(name = "doublebasicsum", parallel = true)
    public Object [][] getDoubleBasicSumValues(){
        return new Object [][]{
                {0,1,1},
                {1,0,1}
        };
    }

    @DataProvider(name = "doubleboundaryvaluessum", parallel = true)
    public Object [][] getDoubleBoundarySumValues(){
        return new Object [][]{
                {Double.MAX_VALUE, 0, Double.MAX_VALUE},
                {0, Double.MAX_VALUE, Double.MAX_VALUE},
                {0, Double.MIN_VALUE, Double.MIN_VALUE},
                {Double.MIN_VALUE, 0, Double. MIN_VALUE}
        };
    }

    @DataProvider(name = "longbasicsub", parallel = true)
    public Object [][] getLongBasicSubValues(){
        return new Object [][] {
                {0,1,-1},
                {1,0,1},
                {-1,1,-2},
                {-1,-1,0}

        };
    }

    @DataProvider(name = "longboundaryvaluessub", parallel = true)
    public Object [][] getLongBoundarySubValues(){
        return new Object [][] {
                {Long.MAX_VALUE,0, Long.MAX_VALUE},
                {0, Long.MAX_VALUE, Long.MIN_VALUE},
                {0,Long.MIN_VALUE, Long.MIN_VALUE},
                {Long.MIN_VALUE,0, Long.MIN_VALUE},
        };
    }

    @DataProvider(name = "doublebasicsub", parallel = true)
    public Object [][] getDoubleBasicSubValues(){
        return new Object [][]{
                {0,1,-1},
                {1,0,1},
        };
    }

    @DataProvider(name = "doubleboundaryvaluessub", parallel = true)
    public Object [][] getDoubleBoundarySubValues(){
        return new Object [][]{
                {Double.MAX_VALUE, 0, Double.MAX_VALUE},
                {0, Double.MAX_VALUE, Double.MIN_VALUE},
                {0, Double.MIN_VALUE, Double.MAX_VALUE},
                {Double.MIN_VALUE, 0, Double. MIN_VALUE}
        };
    }

    @DataProvider(name = "longbasicmult", parallel = true)
    public Object [][] getLongBasicMultValues(){
        return new Object [][]{
                {0,1,0},
                {1,0,0},
                {1, 1, 1},
                {-1,0,0},
                {-1,-1,1},
                {-1,1,-1},
                {1,-1,-1}
        };
    }

    @DataProvider(name = "longboundaryvaluesmult", parallel = true)
    public Object [][] getLongBoundaryMultValues(){
        return new Object [][]{
                {Long.MAX_VALUE,0, 0},
                {0, Long.MAX_VALUE, 0},
                {0,Long.MIN_VALUE, 0},
                {Long.MIN_VALUE,0, 0},
        };
    }

    @DataProvider(name = "doublebasicmult", parallel = true)
    public Object [][] getDoubleBasicValues(){
        return new Object [][]{
                {0.0,1.0,0.0},
                {1.0,0.0,0.0},
                {-1.0,0.0,-0.0},
                {0.0,-1.0,-0.0},
                {-1.0,0.0, -0.0},
                {-1.0,-1.0,1.0},
                {1.0, -1.0, -1.0},
                {-1.0, 1.0, -1.0}
        };
    }

    @DataProvider(name = "doubleboundaryvaluesmult", parallel = true)
    public Object [][] getDoubleBoundaryValues(){
        return new Object [][]{
                {Double.MAX_VALUE, 0, 0},
                {0, Double.MAX_VALUE, 0},
                {0, Double.MIN_VALUE, 0},
                {Double.MIN_VALUE, 0, 0},
                {Double.MAX_VALUE, Double.MAX_VALUE, Double.POSITIVE_INFINITY},
                {Double.MIN_VALUE, Double.MIN_VALUE, 0}
        };
    }

    @DataProvider(name = "longbasicdiv", parallel = true)
    public Object [][] getLongBasicDivValues(){
        return new Object [][]{
                {1, 1, 1},
                {0, 1, 0},
                {-1, -1, 1},
                {-1, 1, -1},
                {1, -1. -1}
        };
    }

    @DataProvider(name = "longboundaryvaluesdiv", parallel = true)
    public Object [][] getLongBoundaryDivValues(){
        return new Object [][]{
                {Long.MAX_VALUE, Long.MIN_VALUE, -1},
                {Long.MIN_VALUE, Long.MAX_VALUE, 1},
                {0, Long.MAX_VALUE, 0},
                {0, Long.MIN_VALUE}
        };
    }

    @DataProvider(name = "longonzerodiv", parallel = true)
    public Object [][] getLongOnZeroDivValues(){
        return new Object [][]{
                {Long.MAX_VALUE, 0},
                {Long.MIN_VALUE, 0}
        };
    }

    @DataProvider(name = "doublebasicdiv", parallel = true)
    public Object [][] getDoubleBasicDivValues(){
        return new Object [][]{
                {0.0, 1.0, 0.0},
                {0.0, -1.0, -0.0},
                {-1.0, -1.0, 1.0},
                {-1.0, 1.0, -1.0},
                {1.0, -1.0, -1.0}
        };
    }

    @DataProvider(name = "doubleboundaryvaluesdiv", parallel = true)
    public Object [][] getDoubleBoundaryDivValues(){
        return new Object [][]{
                {Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY},
                {Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE},
                {-1.0, Double.MAX_VALUE, Double.MIN_VALUE},
                {Double.MIN_VALUE, 1.0, Double.MIN_VALUE},
                {Double.MIN_VALUE, -1.0, 0.0}
        };
    }

    @DataProvider(name = "doubleonzerodiv", parallel = true)
    public Object [][] getDoubleOnZeroDivValues(){
        return new Object [][]{
                {0.1, 0.0, Double.POSITIVE_INFINITY},
                {Double.MIN_VALUE, 0.0, 0.0},
                {Double.MAX_VALUE, 0.0, 0.0},
        };
    }

    @DataProvider(name = "doublebasicpow", parallel = true)
    public Object [][] getDoubleBasicPowValues(){
        return new Object [][]{
                {0.0, 0.0, 0.0},
                {0.0, 1.0, 0.0},
                {0.0, -1.0, Double.POSITIVE_INFINITY},
                {-1.0, 0.0, 1.0}

        };

    }

    @DataProvider(name = "doubleboundaryvaluespow", parallel = true)
    public Object [][] getDoubleBoundaryPowValues(){
        return new Object [][]{
                {Double.MAX_VALUE, 0.0, 1.0},
                {Double.MAX_VALUE, 1.0, Double.MAX_VALUE},
                {Double.MIN_VALUE, 0.0, 1.0},
                {Double.MIN_VALUE, 1.0, Double.MIN_VALUE},
                {Double.MIN_VALUE, Double.MAX_VALUE, 0.0},
                {Double.MIN_VALUE, Double.MAX_VALUE, 0.0},
                {Double.MIN_VALUE, -1.0, Double.POSITIVE_INFINITY},
                {Double.MAX_VALUE, -1.0, 5.562684646268003E-309}
        };
    }

    @DataProvider(name = "doublebasicsqrt", parallel = true)
    public Object [][] getDoubleBasicSqrtValues(){
        return new Object [][]{
                {1.0, 1.0},
                {0.0, 0.0},
                {-1.0, 1.0}
        };
    }

    @DataProvider(name = "doubleboundaryvaluessqrt", parallel = true)
    public Object [][] getDoubleBoundarySqrtValues(){
        return new Object [][]{
                {Double.MAX_VALUE, 1.3407807929942596E154},
                {Double.MIN_VALUE, 2.2227587494850775E-162}
        };
    }
}
