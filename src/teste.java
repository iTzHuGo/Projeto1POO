public static boolean validar(Data d) {
        boolean valida = false;
        if (d.getDia() >= 1 && d.getDia() <= 31 && d.getMes() >= 1 && d.getMes() <= 12 && d.getAno() >= 0)
            valida = true;
        else if(((d.getMes() >= 1 && d.getMes() <= 7) && d.getMes() % 2 != 0))
            valida = true;
        else if (((d.getMes() >= 8 && d.getMes() <= 12) && d.getMes() % 2 == 0))
            valida = true;
        else if ((d.getMes() == 4 || d.getMes() == 6 || d.getMes() == 9 || d.getMes() == 11) && (d.getDia() <= 30))
            valida = true;
        else if (d.getMes() == 2 && Bissexto(d) && d.getDia() <= 29)
            valida = true;
        else if (d.getMes() == 2 && !Bissexto(d) && d.getDia() <= 28)
            valida = true;
        return valida;
    }