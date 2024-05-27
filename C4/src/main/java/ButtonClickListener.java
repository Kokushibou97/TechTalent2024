private class ButtonClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (isComparing) {
            // Si ya se están comparando dos botones, no permitir más clics
            return;
        }

        JButton clickedButton = (JButton) e.getSource();
        int index = -1;
        for (int i = 0; i < buttons.length; i++) {
            if (clickedButton == buttons[i]) {
                index = i;
                break;
            }
        }

        if (clickedButton.getBackground().equals(Color.GRAY) && firstButton != clickedButton) {
            clickedButton.setBackground(colors.get(index));

            if (firstButton == null) {
                firstButton = clickedButton;
                firstColor = colors.get(index);
            } else {
                secondButton = clickedButton;
                secondColor = colors.get(index);
                isComparing = true; // Indicar que estamos en estado de comparación

                if (firstColor.equals(secondColor)) {
                    firstButton.setEnabled(false);
                    secondButton.setEnabled(false);
                    pairsFound++; // Incrementar el contador de parejas encontradas
                    resetSelection();

                    if (pairsFound == 8) { // Verificar si todas las parejas han sido encontradas
                        JOptionPane.showMessageDialog(null, "¡Enhorabuena! Has encontrado todas las parejas.");
                    }
                } else {
                    Timer timer = new Timer(500, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            firstButton.setBackground(Color.GRAY);
                            secondButton.setBackground(Color.GRAY);
                            resetSelection();
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        }
    }

    private void resetSelection() {
        firstButton = null;
        secondButton = null;
        isComparing = false;
    }
}
