package net.nussi;

public class App {




    public static void main(String[] args) {
        String data;

        data = Diagrammer(
                "I_{L1}", 1.558d, 0,
                "I_{L2}", 1.547d, 120,
                "I_{L3}", 1.557d, -120,
                3, "A", "Sym. Stern mit N"
        );
        System.out.println(data);

        data = Diagrammer(
                "U_{L1}", 235.4, 0,
                "U_{L2}", 235.1, 120,
                "U_{L3}", 235.7, -120,
                0.03, "V", "Sym. Stern mit N"
        );
        System.out.println(data);





        data = Diagrammer(
                "I_{L1}", 1.556d, 0,
                "I_{L2}", 1.547d, 120,
                "I_{L3}", 1.558d, -120,
                3, "A", "Sym. Stern ohne N"
        );
        System.out.println(data);

        data = Diagrammer(
                "U_{L1}", 235.2, 0,
                "U_{L2}", 235.8, 120,
                "U_{L3}", 235.7, -120,
                0.03, "V", "Sym. Stern ohne N"
        );
        System.out.println(data);





        data = Diagrammer(
                "I_{L1}", 0.518d, 0,
                "I_{L2}", 0.68d, 120,
                "I_{L3}", 0.593d, -120,
                3, "A", "Unsym. Stern mit N"
        );
        System.out.println(data);

        data = Diagrammer(
                "U_{L1}", 266.5, 0,
                "U_{L2}", 195.7, 120,
                "U_{L3}", 148.4, -120,
                0.03, "V", "Unsym. Stern mit N"
        );
        System.out.println(data);






















        data = Diagrammer(
                "U_{L1}", 403.1, 0,
                "U_{L2}", 403.6, 120,
                "U_{L3}", 404.2, -120,
                0.02, "V", "Sym. Dreieck"
        );
        System.out.println(data);

        data = Diagrammer(
                "I_{L1}", 1.38, 0,
                "I_{L2}", 1.34, 120,
                "I_{L3}", 1.346, -120,
                3, "A", "Sym. Dreieck"
        );
        System.out.println(data);







        data = Diagrammer(
                "U_{L1}", 402.3, 0,
                "U_{L2}", 402.9, 120,
                "U_{L3}", 403.5, -120,
                0.02, "V", "Unsym. Dreieck"
        );
        System.out.println(data);
        data = Diagrammer(
                "I_{L1}", 1.309, 0,
                "I_{L2}", 1.327, 120,
                "I_{L3}", 1.306, -120,
                3, "A", "Unsym. Dreieck"
        );
        System.out.println(data);






        data = Diagrammer(
                "U_{L1}", 408.4, 0,
                "U_{L2}", 408.4, 120,
                "U_{L3}", 409.1, -120,
                0.02, "V", "Unsym. Dreieck"
        );
        System.out.println(data);

        data = Diagrammer(
                "I_{L1}", 1.537, 0,
                "I_{L2}", 1.942, 120,
                "I_{L3}", 2.09, -120,
                3, "A", "Unsym. Dreieck"
        );
        System.out.println(data);






    }


    public static String Diagrammer(
            String t1, double m1, double g1,
            String t2, double m2, double g2,
            String t3, double m3, double g3,
            double scale, String unit, String titel
    ) {

        Arrow a1 = new Arrow(m1*scale, g1);
        Arrow a2 = new Arrow(m2*scale, g2).offset(a1.x2,a1.y2);
        Arrow a3 = new Arrow(m3*scale, g3).offset(a2.x2,a2.y2);

        String data =
                        "\n" +
                        "\n% =====================================================" +
                        "\n\\section{"+titel+"}" +
                        "\n% =====================================================" +
                        "\n" +
                        "\\begin{tikzpicture}[\n" +
                        "\t>=stealth,\n" +
                        "\tthick,\n" +
                        "\tline cap=round,\n" +
                        "\tline join=round\n" +
                        "\t]\n" +
                        "\t\\draw[help lines,lightgray] (-9,-9) grid (9,9);\n" +
                        "\t\\begin{scope}[->]\n" +
                        "\t\t\\draw ("+a1.x1+","+a1.y1+") -- ("+a1.x2+","+a1.y2+") node[midway,below] {$"+t1+"="+m1+unit+"$};\n" +
                        "\t\t\\draw ("+a2.x1+","+a2.y1+") -- ("+a2.x2+","+a2.y2+") node[midway,below] {$"+t2+"="+m2+unit+"$};\n" +
                        "\t\t\\draw ("+a3.x1+","+a3.y1+") -- ("+a3.x2+","+a3.y2+") node[midway,right] {$"+t3+"="+m3+unit+"$}; \n" +
                        "\t\\end{scope}\n" +
                        "\\end{tikzpicture}";


        return data;
    }




}
