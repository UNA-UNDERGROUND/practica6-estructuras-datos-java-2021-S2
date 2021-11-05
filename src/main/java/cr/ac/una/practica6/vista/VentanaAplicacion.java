package cr.ac.una.practica6.vista;

import cr.ac.una.practica6.modelo.Modelo;

/**
 *
 * (c) 2019-2021
 *
 * @author Georges Alfaro S.
 * @version 1.3.0 2021-10-22
 *
 */
public class VentanaAplicacion extends javax.swing.JFrame {

    public VentanaAplicacion(String titulo, Modelo modelo) {
        super(titulo);
        this.modelo = modelo;
        initComponents();
        init();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        panelControl = new javax.swing.JPanel();
        etqNuevaCat = new javax.swing.JLabel();
        campoCategoria = new javax.swing.JTextField();
        espacio1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 16), new java.awt.Dimension(0, 8),
                new java.awt.Dimension(32767, 16));
        etqPertenece = new javax.swing.JLabel();
        campoSuperCategoria = new javax.swing.JTextField();
        espacio2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 16), new java.awt.Dimension(0, 16),
                new java.awt.Dimension(32767, 16));
        btnIncluir = new javax.swing.JButton();
        espacio3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
                new java.awt.Dimension(0, 32767));
        btnEliminar = new javax.swing.JButton();
        panelDScroll = new javax.swing.JScrollPane();
        panelCategorias = new PanelCategorias(modelo);

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new java.awt.BorderLayout(4, 0));

        panelControl.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 2, 2, 2));
        panelControl.setPreferredSize(new java.awt.Dimension(120, 300));
        panelControl.setLayout(new java.awt.GridBagLayout());

        etqNuevaCat.setText("Nueva categoría: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        panelControl.add(etqNuevaCat, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        panelControl.add(campoCategoria, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        panelControl.add(espacio1, gridBagConstraints);

        etqPertenece.setText("Pertenece a: ");
        etqPertenece.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        panelControl.add(etqPertenece, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        panelControl.add(campoSuperCategoria, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        panelControl.add(espacio2, gridBagConstraints);

        btnIncluir.setText("Incluir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        panelControl.add(btnIncluir, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weighty = 0.1;
        panelControl.add(espacio3, gridBagConstraints);

        btnEliminar.setText("Eliminar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        panelControl.add(btnEliminar, gridBagConstraints);

        getContentPane().add(panelControl, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout panelCategoriasLayout = new javax.swing.GroupLayout(panelCategorias);
        panelCategorias.setLayout(panelCategoriasLayout);
        panelCategoriasLayout.setHorizontalGroup(panelCategoriasLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 274, Short.MAX_VALUE));
        panelCategoriasLayout.setVerticalGroup(panelCategoriasLayout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 296, Short.MAX_VALUE));

        panelDScroll.setViewportView(panelCategorias);

        getContentPane().add(panelDScroll, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void init() {
        setVisible(true);
        btnEliminar.addActionListener(l -> {
            onEliminarClicked();
        });
        btnIncluir.addActionListener(l -> {
            onIncluirClicked();
        });
    }

    private void onEliminarClicked() {

    }

    private void onIncluirClicked() {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoSuperCategoria;
    private javax.swing.Box.Filler espacio1;
    private javax.swing.Box.Filler espacio2;
    private javax.swing.Box.Filler espacio3;
    private javax.swing.JLabel etqNuevaCat;
    private javax.swing.JLabel etqPertenece;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPanel panelCategorias;
    private javax.swing.JPanel panelControl;
    private javax.swing.JScrollPane panelDScroll;
    // End of variables declaration//GEN-END:variables
    private final Modelo modelo;
}
