package views;

import controllers.ProductController;
import models.Product;
import models.ResponseType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.UUID;

public class Dashboard extends JFrame {
	private ProductController controller = null;

	public Dashboard() {
		controller = new ProductController();
		initComponents();
	}

	private void loadTable(List<Product> _products) {
		if (_products != null) {
			btnUpdate.setEnabled(false);
			btnDelete.setEnabled(false);
			tableModel.setRowCount(0);
			for (Product product : _products) {
				tableModel.addRow(new Object[]{product.getProductId(),
					product.getProductName(),
					product.getPrice(),
					product.getStock()
				});
			}
		}
	}

	private void uploadProducts() {
		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		String titles[] = {"ID", "PRODUCTO", "PRECIO", "STOCK"};
		tableModel.setColumnIdentifiers(titles);

		List<Product> products = controller.getAllProducts();
		loadTable(products);
		tblProducts.setModel(tableModel);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings ("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		Form = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		txtCode = new javax.swing.JTextField();
		jLabel3 = new javax.swing.JLabel();
		txtProductName = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		txtPrice = new javax.swing.JTextField();
		jLabel5 = new javax.swing.JLabel();
		txtStock = new javax.swing.JTextField();
		btnSearch = new javax.swing.JButton();
		btnRegister = new javax.swing.JButton();
		btnUpdate = new javax.swing.JButton();
		btnDelete = new javax.swing.JButton();
		lblAlertMessage = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblProducts = new javax.swing.JTable();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowOpened(java.awt.event.WindowEvent evt) {
				formWindowOpened(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setText("Productos");

		jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
		jLabel2.setText("Código");

		txtCode.setEditable(false);
		txtCode.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
		txtCode.setEnabled(false);

		jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
		jLabel3.setText("Producto");

		txtProductName.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
		txtProductName.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtProductNameKeyReleased(evt);
			}
		});

		jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
		jLabel4.setText("Precio");

		txtPrice.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

		jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 16)); // NOI18N
		jLabel5.setText("Cantidad");

		txtStock.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N

		btnSearch.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
		btnSearch.setText("Buscar");
		btnSearch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSearchActionPerformed(evt);
			}
		});

		btnRegister.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
		btnRegister.setText("Registrar");
		btnRegister.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRegisterActionPerformed(evt);
			}
		});

		btnUpdate.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
		btnUpdate.setText("Modificar");
		btnUpdate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnUpdateActionPerformed(evt);
			}
		});

		btnDelete.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
		btnDelete.setText("Eliminar");
		btnDelete.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnDeleteActionPerformed(evt);
			}
		});

		lblAlertMessage.setBackground(new java.awt.Color(255, 51, 102));
		lblAlertMessage.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N

		javax.swing.GroupLayout FormLayout = new javax.swing.GroupLayout(Form);
		Form.setLayout(FormLayout);
		FormLayout.setHorizontalGroup(FormLayout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(FormLayout
				.createSequentialGroup()
				.addContainerGap()
				.addGroup(FormLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(FormLayout
						.createSequentialGroup()
						.addGap(32, 32, 32)
						.addGroup(FormLayout
							.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addGroup(FormLayout
								.createSequentialGroup()
								.addGroup(FormLayout
									.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(FormLayout.createSequentialGroup().addComponent(
										jLabel2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										60,
										javax.swing.GroupLayout.PREFERRED_SIZE
									).addGap(16, 16, 16).addComponent(txtCode,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										100,
										javax.swing.GroupLayout.PREFERRED_SIZE
									))
									.addGroup(FormLayout.createSequentialGroup().addComponent(
										jLabel4,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										60,
										javax.swing.GroupLayout.PREFERRED_SIZE
									).addGap(18, 18, 18).addComponent(txtPrice,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										100,
										javax.swing.GroupLayout.PREFERRED_SIZE
									)))
								.addGap(32, 32, 32)
								.addGroup(FormLayout
									.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
									.addGroup(FormLayout.createSequentialGroup().addComponent(
										jLabel5,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										90,
										javax.swing.GroupLayout.PREFERRED_SIZE
									).addGap(16, 16, 16).addComponent(txtStock,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										200,
										javax.swing.GroupLayout.PREFERRED_SIZE
									))
									.addGroup(FormLayout.createSequentialGroup().addComponent(
										jLabel3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										90,
										javax.swing.GroupLayout.PREFERRED_SIZE
									).addGap(16, 16, 16).addComponent(txtProductName,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										340,
										javax.swing.GroupLayout.PREFERRED_SIZE
									))))
							.addGroup(FormLayout.createSequentialGroup().addComponent(
								btnSearch,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								140,
								javax.swing.GroupLayout.PREFERRED_SIZE
							).addGap(32, 32, 32).addComponent(btnRegister,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								140,
								javax.swing.GroupLayout.PREFERRED_SIZE
							).addGap(32, 32, 32).addComponent(btnUpdate,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								140,
								javax.swing.GroupLayout.PREFERRED_SIZE
							).addGap(32, 32, 32).addComponent(btnDelete,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								140,
								javax.swing.GroupLayout.PREFERRED_SIZE
							))
							.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								FormLayout.createSequentialGroup().addComponent(lblAlertMessage,
									javax.swing.GroupLayout.PREFERRED_SIZE,
									438,
									javax.swing.GroupLayout.PREFERRED_SIZE
								).addGap(140, 140, 140)
							))
						.addGap(32, 32, 32))
					.addComponent(jLabel1,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						729,
						Short.MAX_VALUE
					))));
		FormLayout.setVerticalGroup(FormLayout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(FormLayout
				.createSequentialGroup()
				.addGap(0, 0, 0)
				.addComponent(jLabel1)
				.addGap(32, 32, 32)
				.addGroup(FormLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel2)
					.addComponent(txtCode,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						40,
						javax.swing.GroupLayout.PREFERRED_SIZE
					)
					.addComponent(jLabel3)
					.addComponent(txtProductName,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						40,
						javax.swing.GroupLayout.PREFERRED_SIZE
					))
				.addGap(17, 17, 17)
				.addGroup(FormLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(jLabel4)
					.addComponent(txtPrice,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						40,
						javax.swing.GroupLayout.PREFERRED_SIZE
					)
					.addComponent(jLabel5)
					.addComponent(txtStock,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						40,
						javax.swing.GroupLayout.PREFERRED_SIZE
					))
				.addGap(9, 9, 9)
				.addComponent(lblAlertMessage)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(FormLayout
					.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
					.addComponent(btnSearch,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						40,
						javax.swing.GroupLayout.PREFERRED_SIZE
					)
					.addComponent(btnRegister,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						40,
						javax.swing.GroupLayout.PREFERRED_SIZE
					)
					.addComponent(btnUpdate,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						40,
						javax.swing.GroupLayout.PREFERRED_SIZE
					)
					.addComponent(btnDelete,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						40,
						javax.swing.GroupLayout.PREFERRED_SIZE
					))
				.addGap(16, 16, 16)));

		tblProducts.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
		tblProducts.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{
			{},
			{},
			{},
			{}
		}, new String[]{

		}));
		tblProducts.setRowHeight(25);
		tblProducts.getTableHeader().setResizingAllowed(false);
		tblProducts.getTableHeader().setReorderingAllowed(false);
		tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblProductsMouseClicked(evt);
			}
		});
		jScrollPane1.setViewportView(tblProducts);

		javax.swing.GroupLayout
			jPanel2Layout
			= new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(jPanel2Layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGap(0, 735, Short.MAX_VALUE)
			.addGroup(jPanel2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout
					.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						723,
						Short.MAX_VALUE
					)
					.addContainerGap())));
		jPanel2Layout.setVerticalGroup(jPanel2Layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGap(0, 341, Short.MAX_VALUE)
			.addGroup(jPanel2Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout
					.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane1,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						329,
						Short.MAX_VALUE
					)
					.addContainerGap())));

		javax.swing.GroupLayout
			jPanel1Layout
			= new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(jPanel2,
				javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.PREFERRED_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE
			)
			.addGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(Form,
					javax.swing.GroupLayout.Alignment.TRAILING,
					javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE,
					Short.MAX_VALUE
				)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel1Layout
					.createSequentialGroup()
					.addGap(0, 248, Short.MAX_VALUE)
					.addComponent(jPanel2,
						javax.swing.GroupLayout.PREFERRED_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.PREFERRED_SIZE
					)
			)
			.addGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addComponent(Form,
					javax.swing.GroupLayout.PREFERRED_SIZE,
					javax.swing.GroupLayout.DEFAULT_SIZE,
					javax.swing.GroupLayout.PREFERRED_SIZE
				).addGap(0, 343, Short.MAX_VALUE))));

		javax.swing.GroupLayout
			layout
			= new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(jPanel1,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				Short.MAX_VALUE
			));
		layout.setVerticalGroup(layout
			.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addComponent(jPanel1,
				javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				Short.MAX_VALUE
			));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void tblProductsMouseClicked(MouseEvent evt) {
		lblAlertMessage.setText("");
		if (evt.getClickCount() == 2) {
			btnSearch.setEnabled(false);
			btnRegister.setEnabled(false);
			btnUpdate.setEnabled(true);
			btnDelete.setEnabled(true);
			int selectedRow = tblProducts.getSelectedRow();
			if (selectedRow >= 0) {
				String productId = tblProducts.getValueAt(selectedRow, 0).toString();
				String productName = tblProducts.getValueAt(selectedRow, 1).toString();
				double price = Double.parseDouble(tblProducts
					.getValueAt(selectedRow, 2)
					.toString());
				short stock = Short.parseShort(tblProducts
					.getValueAt(selectedRow, 3)
					.toString());


				txtCode.setText(productId);
				txtProductName.setText(productName);
				txtPrice.setText(String.valueOf(price));
				txtStock.setText(String.valueOf(stock));
			}
		}
	}

	private void txtProductNameKeyReleased(KeyEvent evt) {
		if (txtProductName.getText().isEmpty()) {
			btnSearch.setEnabled(true);
			btnRegister.setEnabled(true);

			uploadProducts();
			clearFields();
		}
	}

	private void formWindowOpened(java.awt.event.WindowEvent evt) {
		uploadProducts();
	}

	private void btnSearchActionPerformed(ActionEvent evt) {
		String productToSearch = txtProductName.getText().trim();
		List<Product> products;

		if (!productToSearch.isEmpty() && !productToSearch.isBlank() &&
			productToSearch.length() != 0) {
			products = controller.searchProduct(productToSearch.toLowerCase());
			if (products.size() == 0)
				alertMessage("No hay ninguna coincidencia.", "success");

			loadTable(products);
		} else {
			clearFields();
			alertMessage("Ingrese un valor a buscar", "error");
		}
	}

	private void btnRegisterActionPerformed(ActionEvent evt) {
		Product product = validateFields();

		if (product != null) {
			ResponseType responseType = controller.createProduct(product);

			alertMessage(responseType.getMessage(), responseType.getType());
			System.out.println(responseType.getMessage());
			clearFields();
			uploadProducts();
		} else {
			alertMessage("Complete los campos correctamente!.", "error");
			System.out.println("Complete los campos correctamente!.");
		}
	}

	private void btnUpdateActionPerformed(ActionEvent evt) {
		String productId = txtCode.getText().trim();
		Product product = validateFields();

		if (product != null && !productId.isEmpty()) {
			ResponseType
				responseType
				= controller.updateProduct(new Product(UUID.fromString(productId),
				product.getProductName(),
				product.getPrice(),
				product.getStock()
			));
			alertMessage(responseType.getMessage(), responseType.getType());
			System.out.println(responseType.getMessage());
			clearFields();
			uploadProducts();
		} else {
			alertMessage("Complete los campos correctamente!.", "error");
			System.out.println("Complete los campos correctamente!.");
		}
	}

	private void btnDeleteActionPerformed(ActionEvent evt) {
		String productId = txtCode.getText().trim();
		if (!productId.isEmpty()) {
			ResponseType responseType = controller.deleteProduct(UUID.fromString(
				productId));
			alertMessage(responseType.getMessage(), responseType.getType());
			System.out.println(responseType.getMessage());
			uploadProducts();
			clearFields();
		} else {
			alertMessage("Debe indicar el código del producto!.", "error");
			System.out.println("Debe indicar el código del producto!.");
		}
	}

	private Product validateFields() {
		String productName = txtProductName.getText().trim();
		String priceText = txtPrice.getText().trim();
		String stockText = txtStock.getText().trim();

		boolean isValid = !productName.isEmpty() && !priceText.isEmpty() &&
			!stockText.isEmpty();

		double price = 0;
		short stock = 0;
		try {
			price = Double.parseDouble(priceText);
			stock = Short.parseShort(stockText);
		} catch (NumberFormatException ex) {
			alertMessage("Ingrese un valor positivio", "error");
			isValid = false;
		}

		if (price < 0 || stock < 0) {
			isValid = false;
		}

		Product product = null;
		if (isValid) {
			product = new Product(productName, price, stock);
		}
		return product;
	}

	private void clearFields() {
		txtCode.setText("");
		txtProductName.setText("");
		txtPrice.setText("");
		txtStock.setText("");
		txtProductName.requestFocus(true);
		btnSearch.setEnabled(true);
		btnRegister.setEnabled(true);
	}

	private void alertMessage(String _message, String _type) {
		if (_type.equals("success")) {
			lblAlertMessage.setForeground(new Color(0, 194, 8));
		} else if (_type.equals("error")) {
			lblAlertMessage.setForeground(new Color(252, 87, 87));
		} else if (_type.equals("warning")) {
			lblAlertMessage.setForeground(new Color(246, 205, 5));
		}

		lblAlertMessage.setText(_message);

		Timer timer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblAlertMessage.setText("");
			}
		});
		timer.setRepeats(false);
		timer.start();
	}

	private DefaultTableModel tableModel;
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel Form;
	private javax.swing.JButton btnDelete;
	private javax.swing.JButton btnRegister;
	private javax.swing.JButton btnSearch;
	private javax.swing.JButton btnUpdate;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lblAlertMessage;
	private javax.swing.JTable tblProducts;
	private javax.swing.JTextField txtCode;
	private javax.swing.JTextField txtPrice;
	private javax.swing.JTextField txtProductName;
	private javax.swing.JTextField txtStock;
	// End of variables declaration//GEN-END:variables
}
