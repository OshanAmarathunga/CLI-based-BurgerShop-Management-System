import java.util.*;

class bugerShop {

  final static double BURGERPRICE = 500;
  public static final int PREPARING = 0;
  public static final int DELIVERED = 1;
  public static final int CANCEL = 2;
  public static int num = 1;

  public static int orderStatus[] = new int[0];
  public static String orderIDArry[] = new String[0];
  public static int customerIdArray[] = new int[0];
  public static String customerNameArray[] = new String[0];
  public static int customerIdSaveArray[] = new int[0];
  public static int qtyArry[] = new int[0];
 


  // -------------------------Clear Consol----------------------------------------
  public final static void clearConsole() {
    try {
      final String os = System.getProperty("os.name");
      if (os.contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }
    } catch (final Exception e) {
      e.printStackTrace();
      // Handle any exceptions.
    }
  }

  // -------------------------------------------HeaderScreen---------------------
  public static void headerScreentemp(String header) {
    char dash = '-';
    int length = 120;
    int wordLeangth = header.length();
    char margin = '|';
    for (int i = 0; i < length; i++) {
      System.out.print(dash);
    }
    System.out.println("");
    System.out.print(margin);

    for (int j = 0; j < ((length - wordLeangth) / 2); j++) {
      System.out.print(" ");
    }
    System.out.print(header);////

    for (int j1 = 0; j1 < ((length - wordLeangth) / 2) - 2; j1++) {
      System.out.print(" ");
    }
    System.out.println(margin);

    for (int i2 = 0; i2 < length; i2++) {
      System.out.print(dash);
    }
    System.out.println(" ");
    System.out.println(" ");
  }

  // ------------------------------------------------------Home---------------------
  public static void home() {
    headerScreentemp("iHungry Burger");

    Scanner in = new Scanner(System.in);
    System.out.printf("  [1] %10s" + "                              [2] %10s%n", "Place Order", "Search Best Customer");
    System.out.printf("  [3] %10s" + "                             [4] %10s%n", "Search Order", "Search Customer");
    System.out.printf("  [5] %10s" + "                              [6] %10s%n", "View Orders", "Update Order Details");
    System.out.printf("  [7] %s%n%n", "Exit");

    int input = -1;
    while (input <= 0 || input > 7) {
      System.out.print("Enter an option to continue : ");
      input = in.nextInt();
      System.out.println((input <= 0 || input > 7) ? "Wrong Input,Please enter NO 1 to 7 options only..." : "");
    }
    clearConsole();

    // -------------------------------------Selection of option----------------
    switch (input) {

      case 1:
        PlaceOrder();
        break;
      case 2:
        SearchBestCustomer();
        break;
      case 3:
        SearchOrder();
        break;
      case 4:
        SearchCustomer();
        break;
      case 5:
        ViewOrders();
        break;
      case 6:
        UpdateOrderDetails();
        break;
      case 7:
        Exit();
        break;

    }
  }

  // ----------------------------------------Order ID Creator
  public static String orderIDCreator(int num) {
    String orderID = "";
    int c = 1;
    for (int i = 0; i > 0; i++) {
      num = num / 10;
      c++;

    }
    if (c == 4) {
      orderID = "B" + num;
    } else {
      if (c == 3) {
        orderID = "B0" + num;
      } else {
        if (c == 2) {
          orderID = "B00" + num;
        } else {
          if (c == 1) {
            orderID = "B000" + num;
          }

        }

      }
    }
    /*
     * String orderIDTemp[] = new String[orderIDArry.length + 1];
     * for (int i = 0; i < orderIDArry.length; i++) {
     * orderIDTemp[i] = orderIDArry[i];
     * }
     * orderIDTemp[orderIDTemp.length - 1] = orderID;
     * orderIDArry = orderIDTemp;
     */
    return orderID;

  }

  // ----------------------------------Place Order---------------------
  public static void PlaceOrder() {

    Scanner in = new Scanner(System.in);
    boolean command1 = true;
    L5: while (command1) {
      headerScreentemp("PLACE ORDER ");
      boolean command2 = true;
      boolean command3 = true;
      boolean command4 = true;
      boolean command5 = true;

      System.out.printf("ORDER ID - %S%n", orderIDCreator(num)); //B0001
      System.out.println("================");

      L1: while (command2) {
        System.out.print("Enter Customer ID (Phone no) : ");
        long phoneNo = in.nextLong();

        if (phoneNumberchecker(phoneNo)) {
          String name = existingCustomerchecker(phoneNo);

          if (name.equals("n")) {

            System.out.print("Enter Customer Name          : ");
            String CustomerName = in.next();

            int burgerQty = 0;
            L6: while (true) {
              System.out.print("Enter Burger Quantity        : ");
              burgerQty = in.nextInt();
              if (burgerQty == 0 | burgerQty < 0) {
                System.out.println("Wrong Input for QTY... Enter Again");
              } else {
                break L6;
              }
            }

            System.out.printf("Total Value                  : %.2f%n", (BURGERPRICE * burgerQty));

            System.out.print("               Are you confirm order ( y/n ) : ");
            String command = in.next();
            char c = command.toLowerCase().charAt(0);
            L3: while (command3) {

              if (c == 'y') {
                System.out.println("------Your order is enter to the system successfully-----");
                System.out.println("");
                int customerIdArrayTemp[] = new int[customerIdArray.length + 1];// -----insert to customer id array
                for (int i = 0; i < customerIdArray.length; i++) {
                  customerIdArrayTemp[i] = customerIdArray[i];
                }
                customerIdArrayTemp[customerIdArrayTemp.length - 1] = (int) phoneNo;
                customerIdArray = customerIdArrayTemp;
                // ------------------------------------------------------------------------------

                int customerIdSaveArrayTemp[] = new int[customerIdSaveArray.length + 1];// ---insert to cus id save
                for (int i = 0; i < customerIdSaveArray.length; i++) {
                  customerIdSaveArrayTemp[i] = customerIdSaveArray[i];
                }
                customerIdSaveArrayTemp[customerIdSaveArrayTemp.length - 1] = (int) phoneNo;
                customerIdSaveArray = customerIdSaveArrayTemp;
                // ------------------------------------------------------------------------------

                String customerNameArryTemp[] = new String[customerNameArray.length + 1];// --insert to customerName
                for (int i = 0; i < customerNameArray.length; i++) {
                  customerNameArryTemp[i] = customerNameArray[i];
                }
                customerNameArryTemp[customerNameArryTemp.length - 1] = CustomerName;
                customerNameArray = customerNameArryTemp;
                // ------------------------------------------------------------------------------

                int qtyArryTemp[] = new int[qtyArry.length + 1];// -----insert to qty array
                for (int i = 0; i < qtyArry.length; i++) {
                  qtyArryTemp[i] = qtyArry[i];
                }
                qtyArryTemp[qtyArryTemp.length - 1] = burgerQty;
                qtyArry = qtyArryTemp;
                // ------------------------------------------------------------------------------

                int orderStatusTemp[] = new int[orderStatus.length + 1];// -----insert to qty array
                for (int i = 0; i < orderStatus.length; i++) {
                  orderStatusTemp[i] = orderStatus[i];
                }
                orderStatusTemp[orderStatusTemp.length - 1] = 0;
                orderStatus = orderStatusTemp;
                // ------------------------------------------------------------------------------
                String orderIDTemp[] = new String[orderIDArry.length + 1];
                for (int i = 0; i < orderIDArry.length; i++) {
                  orderIDTemp[i] = orderIDArry[i];
                }
                orderIDTemp[orderIDTemp.length - 1] = orderIDCreator(num);
                orderIDArry = orderIDTemp;

                command3 = false;
                num++;

                L4: while (command5) {
                  System.out.print("Do you want to place another order ( y/n ) : ");
                  String commd = in.next();

                  char c1 = commd.toLowerCase().charAt(0);
                  if (c1 == 'y') {// y
                    command5 = false;
                    command3 = false;
                    command2 = false;
                    clearConsole();

                  } else {
                    if (c1 == 'n') {// n
                      command5 = false;
                      command1 = false;
                      command3 = false;
                      command2 = false;
                      clearConsole();

                    } else {

                      System.out.println("Please enter (y) or (n) only..");

                    }
                  }

                }

              }

              else {
                if (c == 'n') {// n
                  L4: while (command4) {
                    System.out.print("Do you want to place another order ( y/n ) : ");
                    String commd = in.next();

                    char c1 = commd.toLowerCase().charAt(0);
                    if (c1 == 'y') {// y
                      command4 = false;
                      command3 = false;
                      command2 = false;
                      clearConsole();

                    } else {
                      if (c1 == 'n') {// n
                        command4 = false;
                        command3 = false;
                        command2 = false;
                        command1 = false;
                        clearConsole();

                      } else {

                        System.out.print("Please enter (y) or (n) only..");

                      }
                    }

                  }

                } else {

                  System.out.print("Please enter (y) or (n) only..");

                }
              }
            }

          } else {
            System.out.printf("Customer Name                : %s%n", name);

            int burgerQty = 0;
            L7: while (true) {
              System.out.print("Enter Burger Quantity        : ");
              burgerQty = in.nextInt();
              if (burgerQty == 0 | burgerQty < 0) {
                System.out.println("Wrong Input for QTY... Enter Again");
              } else {
                break L7;
              }
            }

            System.out.printf("Total Value                  : %.2f%n", (BURGERPRICE * burgerQty));

            System.out.print("               Are you confirm order ( y/n ) : ");
            String command = in.next();
            char c = command.toLowerCase().charAt(0);
            L3: while (command3) {

              if (c == 'y') {
                System.out.println("------Your order is enter to the system successfully-----");
                System.out.println("");

                int customerIdSaveArrayTemp[] = new int[customerIdSaveArray.length + 1];// ---insert to cus id save
                for (int i = 0; i < customerIdSaveArray.length; i++) {
                  customerIdSaveArrayTemp[i] = customerIdSaveArray[i];
                }
                customerIdSaveArrayTemp[customerIdSaveArrayTemp.length - 1] = (int) phoneNo;
                customerIdSaveArray = customerIdSaveArrayTemp;

                // ------------------------------------------------------------------------------

                int qtyArryTemp[] = new int[qtyArry.length + 1];// -----insert to qty array
                for (int i = 0; i < qtyArry.length; i++) {
                  qtyArryTemp[i] = qtyArry[i];
                }
                qtyArryTemp[qtyArryTemp.length - 1] = burgerQty;
                qtyArry = qtyArryTemp;
                // ------------------------------------------------------------------------------

                int orderStatusTemp[] = new int[orderStatus.length + 1];// -----insert to qty array
                for (int i = 0; i < orderStatus.length; i++) {
                  orderStatusTemp[i] = orderStatus[i];
                }
                orderStatusTemp[orderStatusTemp.length - 1] = 0;
                orderStatus = orderStatusTemp;
                // ------------------------------------------------------------------------------
                String orderIDTemp[] = new String[orderIDArry.length + 1];
                for (int i = 0; i < orderIDArry.length; i++) {
                  orderIDTemp[i] = orderIDArry[i];
                }
                orderIDTemp[orderIDTemp.length - 1] = orderIDCreator(num);
                orderIDArry = orderIDTemp;

                command3 = false;
                num++;

                L4: while (command5) {
                  System.out.print("Do you want to place another order ( y/n ) : ");
                  String commd = in.next();

                  char c1 = commd.toLowerCase().charAt(0);
                  if (c1 == 'y') {// y
                    command5 = false;
                    command3 = false;
                    command2 = false;
                    clearConsole();

                  } else {
                    if (c1 == 'n') {// n
                      command5 = false;
                      command1 = false;
                      command3 = false;
                      command2 = false;
                      clearConsole();
                      break;

                    } else {

                      System.out.println("Please enter (y) or (n) only..");

                    }
                  }

                }

              }

              else {
                if (c == 'n') {// n
                  L4: while (command4) {
                    System.out.print("Do you want to place another order ( y/n ) : ");
                    String commd = in.next();

                    char c1 = commd.toLowerCase().charAt(0);
                    if (c1 == 'y') {// y
                      command4 = false;
                      command3 = false;
                      command2 = false;
                      clearConsole();

                    } else {
                      if (c1 == 'n') {// n
                        command4 = false;
                        command3 = false;
                        command2 = false;
                        command1 = false;
                        clearConsole();

                      } else {

                        System.out.print("Please enter (y) or (n) only..");

                      }
                    }

                  }

                } else {

                  System.out.print("Please enter (y) or (n) only..");

                }
              }
            }

          }

        } else {
          System.out.println("Wrong Number,Please enter again..");

        }
      }

    }
    clearConsole();
    home();

  }

  // --------------------------CUSTOMERCHECKER-------
  public static String existingCustomerchecker(long phoneNo) {
    String result = "n";
    for (int i = 0; i < customerIdArray.length; i++) {
      if (phoneNo == customerIdArray[i]) {
        result = customerNameArray[i];
      }
    }
    return result;

  }

  // -------duplicate checker-------------
  public static boolean isDuplicate(int num, int[] ar) {
    for (int i = 0; i < ar.length; i++) {
      if (num == ar[i]) {
        return true;
      }
    }
    return false;
  }

  // -------------------------NUMBER CHECKER--------------
  public static boolean phoneNumberchecker(long phoneNo) {
    String pn = String.valueOf(phoneNo);
    int firstCharactor = (int) pn.charAt(0);
    int lengthOfPhoneNo = pn.length();

    if (firstCharactor == 0 | lengthOfPhoneNo == 9) {
      return true;
    } else {
      return false;
    }

  }

  // ---------------------------------SearchBestCustomer---------------------
  public static void SearchBestCustomer() {
    Scanner in = new Scanner(System.in);
    headerScreentemp("BEST Customer ");

    int customerIdArrayCOPY[] = new int[customerIdArray.length];// ----get copy
    for (int i = 0; i < customerIdArrayCOPY.length; i++) {
      customerIdArrayCOPY[i] = customerIdArray[i];
    }

    String customerNameArrayCOPY[] = new String[customerNameArray.length];// ----get copy
    for (int i = 0; i < customerNameArrayCOPY.length; i++) {
      customerNameArrayCOPY[i] = customerNameArray[i];
    }

    int customerIdSaveArrayCOPY[] = new int[customerIdSaveArray.length];// ----get copy
    for (int i = 0; i < customerIdSaveArray.length; i++) {
      customerIdSaveArrayCOPY[i] = customerIdSaveArray[i];
    }

    int qtyArryCOPY[] = new int[qtyArry.length];// ----get copy
    for (int i = 0; i < qtyArry.length; i++) {
      qtyArryCOPY[i] = qtyArry[i];
    }

    for (int i = 1; i < customerIdSaveArrayCOPY.length; i++) { // sort
      for (int j = 0; j < i; j++) {
        if (customerIdSaveArrayCOPY[i] < customerIdSaveArrayCOPY[j]) {
          int temp1 = customerIdSaveArrayCOPY[i];
          customerIdSaveArrayCOPY[i] = customerIdSaveArrayCOPY[j];
          customerIdSaveArrayCOPY[j] = temp1;

          int temp3 = qtyArryCOPY[i];
          qtyArryCOPY[i] = qtyArryCOPY[j];
          qtyArryCOPY[j] = temp3;
        }
      }
    }

    int[] customerIds = new int[customerIdSaveArrayCOPY.length];
    int[] quantities = new int[qtyArryCOPY.length];
    int size = 0;

    for (int i = 0; i < customerIdSaveArrayCOPY.length; i++) {
      int customerId = customerIdSaveArrayCOPY[i];
      int qty = qtyArryCOPY[i];

      int index = indexOf(customerIds, size, customerId);

      if (index != -1) {
        quantities[index] += qty;
      } else {
        customerIds[size] = customerId;
        quantities[size] = qty;
        size++;
      }
    }

    int[] totalArryMainTEMP = new int[customerIdArray.length];
    for (int i = 0; i < customerIdArray.length; i++) {
      totalArryMainTEMP[i] = quantities[i];
    }

    for (int i = 1; i < customerIdArrayCOPY.length; i++) { // sort
      for (int j = 0; j < i; j++) {
        if (customerIdArrayCOPY[i] < customerIdArrayCOPY[j]) {
          int temp1 = customerIdArrayCOPY[i];
          customerIdArrayCOPY[i] = customerIdArrayCOPY[j];
          customerIdArrayCOPY[j] = temp1;

          String temp3 = customerNameArrayCOPY[i];
          customerNameArrayCOPY[i] = customerNameArrayCOPY[j];
          customerNameArrayCOPY[j] = temp3;
        }
      }
    }

    for (int i = 1; i < totalArryMainTEMP.length; i++) { // sort
      for (int j = 0; j < i; j++) {
        if (totalArryMainTEMP[i] < totalArryMainTEMP[j]) {
          int temp1 = totalArryMainTEMP[i];
          totalArryMainTEMP[i] = totalArryMainTEMP[j];
          totalArryMainTEMP[j] = temp1;

          int temp3 = customerIdArrayCOPY[i];
          customerIdArrayCOPY[i] = customerIdArrayCOPY[j];
          customerIdArrayCOPY[j] = temp3;

          String temp4 = customerNameArrayCOPY[i];
          customerNameArrayCOPY[i] = customerNameArrayCOPY[j];
          customerNameArrayCOPY[j] = temp4;
        }
      }
    }

    /*
     * System.out.println(Arrays.toString(customerNameArrayCOPY));
     * System.out.println(Arrays.toString(customerIdArrayCOPY));
     * System.out.println(Arrays.toString(totalArryMainTEMP));
     */

    System.out.println("---------------------------------------------------------------------------------");
    System.out.printf("%15s" + "%20s" + "%40s%n", "CustomerID", "Name", "Total");
    System.out.println("---------------------------------------------------------------------------------");

    for (int i = 0; i < customerIdArrayCOPY.length; i++) {
      System.out.printf("%15s" + "%20s" + "%40.2f%n", customerIdArrayCOPY[customerIdArrayCOPY.length - i - 1],
          customerNameArrayCOPY[customerNameArrayCOPY.length - i - 1],
          (totalArryMainTEMP[totalArryMainTEMP.length - i - 1] * 500.00));
    }
    System.out.println("---------------------------------------------------------------------------------");

    boolean Command = true;
    L7: while (Command) {
      System.out.print("Do you want to go back to main menu ( y/n ) : ");
      String command = in.next();
      char c = command.toLowerCase().charAt(0);
      if (c == 'y') {
        clearConsole();
        Command = false;
        home();

      } else {
        if (c == 'n') {
          Command = false;
          clearConsole();
          SearchBestCustomer();

        } else {
          System.out.println("Please Enter Y or N onny....");

        }
      }

    }

  }

  private static int indexOf(int[] array, int size, int target) {
    for (int i = 0; i < size; i++) {
      if (array[i] == target) {
        return i;
      }
    }
    return -1;
  }

  // ---------------------------------equal order id checker
  public static int OrderIdChecker(String orderIdInput) {
    int output = -1;
    for (int i = 0; i < orderIDArry.length; i++) {
      if (orderIdInput.equals(orderIDArry[i])) {
        output = i;
      }
    }
    return output;

  }

  // ---------------------------------equal order id checker
  public static int customerIdChecker(int customerIdInput) {
    int output = -1;
    for (int i = 0; i < customerIdArray.length; i++) {
      if (customerIdInput == customerIdArray[i]) {
        output = i;
      }
    }
    return output;

  }

  // ---------------------------------------Search Order---------------------
  public static void SearchOrder() {

    Scanner in = new Scanner(System.in);
    Boolean comand = true;
    L1: while (comand) {
      headerScreentemp("SEARCH ORDER DETAILS");

      System.out.print("Enter order ID : ");
      String orderIdInput = in.next();
      if (OrderIdChecker(orderIdInput) == -1) {
        System.out.print("Invalid order ID. Do you want to enter again ( y/n ): ");
        String command = in.next();
        char c = command.toLowerCase().charAt(0);
        if (c == 'y') {
          clearConsole();
        } else {
          if (c == 'n') {

            clearConsole();
            comand = false;
            home();
          } else {
            System.out.println("Please enter Y or N only....");

          }
        }

      } else {

        int OrderIDIndex = OrderIdChecker(orderIdInput);

        int customerID = customerIdSaveArray[OrderIDIndex];
        int customerIDIndex = 0;
        for (int i = 0; i < customerIdArray.length; i++) {
          if (customerID == customerIdArray[i]) {
            customerIDIndex = i;
          }
        }

        double orderValue = (500 * qtyArry[OrderIDIndex]);
        String status = orderStatus[OrderIDIndex] == 0 ? "Preparing"
            : (orderStatus[OrderIDIndex] == 1 ? "Deliverd" : "Canceld");

        System.out.println(
            "------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%15s" + "%20s" + "%20s" + "%20s" + "%20s" + "%20s%n", "OrderID", "CustomerID", "Name",
            "Quantity", "OrderValue", "OrderStatus");
        System.out.println(
            "------------------------------------------------------------------------------------------------------------------------------");

        System.out.printf("%15s" + "%20s" + "%20s" + "%20s" + "%20.2f" + "%20s%n", orderIdInput,
            customerIdSaveArray[OrderIDIndex], customerNameArray[customerIDIndex], qtyArry[OrderIDIndex], orderValue,
            status);

        System.out.println(
            "------------------------------------------------------------------------------------------------------------------------------");

        boolean Command = true;
        L7: while (Command) {
          System.out.print("Do you want to go back to main menu ( y/n ) : ");
          String command = in.next();
          char c = command.toLowerCase().charAt(0);
          if (c == 'y') {
            clearConsole();
            Command = false;
            home();

          } else {
            if (c == 'n') {
              Command = false;
              clearConsole();
              SearchOrder();

            } else {
              System.out.println("Please Enter Y or N onny....");

            }
          }

        }

      }

    }

  }

  // -----------------------------------Search Customer---------------------
  public static void SearchCustomer() {
    Scanner in = new Scanner(System.in);
    boolean comand = true;
    while (comand) {

      headerScreentemp("SEARCH CUSTOMER DETAILS");

      System.out.print("Enter Customer ID : ");
      int customerIdInput = in.nextInt();

      if (customerIdChecker(customerIdInput) == -1) {
        System.out.print("Invalid Customer ID. Do you want to enter again ( y/n ): ");
        String command = in.next();
        char c = command.toLowerCase().charAt(0);
        if (c == 'y') {
          clearConsole();
        } else {
          if (c == 'n') {

            clearConsole();
            comand = false;
            home();
          } else {
            System.out.println("Please enter Y or N only....");

          }
        }

      } else {
        System.out.println("\n\n");
        System.out.println("Customer ID    : " + customerIdInput);
        System.out.println("Customer Name  : " + customerNameArray[customerIdChecker(customerIdInput)]);
        System.out.println("\n\n");

        System.out.println("Customer order Detais");
        System.out.println("=========================");

        System.out.println("--------------------------------------------------------");
        System.out.printf("%10s" + "%20s" + "%20s%n", "Order_ID", "Order_Quantity", "Total_Value");
        System.out.println("--------------------------------------------------------");

        int customerIdSaveArrayTEMP[] = new int[customerIdSaveArray.length];// ----get copy
        for (int i = 0; i < customerIdSaveArray.length; i++) {
          customerIdSaveArrayTEMP[i] = customerIdSaveArray[i];

        }

        String orderIDArryTEMP[] = new String[orderIDArry.length];// ----get copy
        for (int i = 0; i < orderIDArry.length; i++) {
          orderIDArryTEMP[i] = orderIDArry[i];

        }

        int qtyArryTEMP2[] = new int[qtyArry.length];// ----get copy
        for (int i = 0; i < qtyArry.length; i++) {
          qtyArryTEMP2[i] = qtyArry[i];

        }

        for (int i = 1; i < customerIdSaveArrayTEMP.length; i++) { // sort
          for (int j = 0; j < i; j++) {
            if (customerIdSaveArrayTEMP[i] < customerIdSaveArrayTEMP[j]) {
              int temp1 = customerIdSaveArrayTEMP[i];
              customerIdSaveArrayTEMP[i] = customerIdSaveArrayTEMP[j];
              customerIdSaveArrayTEMP[j] = temp1;

              String temp2 = orderIDArryTEMP[i];
              orderIDArryTEMP[i] = orderIDArryTEMP[j];
              orderIDArryTEMP[j] = temp2;

              int temp3 = qtyArryTEMP2[i];
              qtyArryTEMP2[i] = qtyArryTEMP2[j];
              qtyArryTEMP2[j] = temp3;
            }
          }
        }
       // System.out.println(Arrays.toString(orderIDArryTEMP));
        //System.out.println(Arrays.toString(qtyArryTEMP2));

        for (int i = 0; i < customerIdSaveArrayTEMP.length; i++) {
          if (customerIdInput == customerIdSaveArrayTEMP[i]) {

            System.out.printf("%10s" + "%20s" + "%20.2f%n", orderIDArryTEMP[i], qtyArryTEMP2[i],
                (500.00 * qtyArryTEMP2[i]));
            System.out.println("--------------------------------------------------------");

          }
        }
        System.out.println("\n");
        boolean Cmnd1 = true;
        while (Cmnd1) {
          System.out.print("Do you want to search another Customer Details ( y/n ) : ");
          String command = in.next();
          char c = command.toLowerCase().charAt(0);
          if (c == 'y') {
            clearConsole();
            Cmnd1 = false;

          } else {
            if (c == 'n') {
              Cmnd1 = false;
              clearConsole();
              home();

            } else {
              System.out.println("Please Enter Y or N onny....");

            }
          }

        }

      }
    }

  }

  // --------------------------------------View Order---------------------
  public static void ViewOrders() {
    Scanner in = new Scanner(System.in);
    headerScreentemp("VIEW ORDER LIST ");
    int input = 0;
    L1: while (true) {
      System.out.println("    [1] Preparing Order ");
      System.out.println("    [2] Deliverd Order");
      System.out.println("    [3] Cancelled Order ");
      System.out.println("\n");
      System.out.print("Enter an option to continue : ");
      input = in.nextInt();
      if (input <= 0 | input > 3) {
        System.out.println("Please enter NO:1 to NO:3 options only");
      } else {
        break L1;
      }

    }
    switch (input) {
      case 1:
        clearConsole();
        PreparingOrder();
        break;
      case 2:
        clearConsole();
        DeliverdOrder();
        break;
      case 3:
        clearConsole();
        CancelledOrder();
        break;

      default:
        break;
    }

  }

  public static void PreparingOrder() {
    Scanner in = new Scanner(System.in);

    headerScreentemp("PREPARING ORDER");
    System.out
        .println("-----------------------------------------------------------------------------------------------");
    System.out.printf("%10s" + "%20s" + "%20s" + "%20s" + "%20s%n", "Order_ID", "Customer_ID", "Name", "Quantity",
        "OrderValue");
    System.out
        .println("-----------------------------------------------------------------------------------------------");

    for (int i = 0; i < orderStatus.length; i++) {
      if (orderStatus[i] == 0) {
        System.out.printf("%10s" + "%20s" + "%20s" + "%20s" + "%20.2f%n", orderIDArry[i], customerIdSaveArray[i],
            customerNameArray[customerIdChecker(customerIdSaveArray[i])], qtyArry[i], (500.00 * qtyArry[i]));

      }
    }
    System.out
        .println("-----------------------------------------------------------------------------------------------");

    boolean Command = true;
    L7: while (Command) {
      System.out.print("Do you want to go back to main menu ( y/n ) : ");
      String command = in.next();
      char c = command.toLowerCase().charAt(0);
      if (c == 'y') {
        clearConsole();
        Command = false;
        home();

      } else {
        if (c == 'n') {
          Command = false;
          clearConsole();
          PreparingOrder();

        } else {
          System.out.println("Please Enter Y or N onny....");

        }
      }

    }

  }

  public static void DeliverdOrder() {
    Scanner in = new Scanner(System.in);

    headerScreentemp("DELIVERD ORDER");
    System.out
        .println("-----------------------------------------------------------------------------------------------");
    System.out.printf("%10s" + "%20s" + "%20s" + "%20s" + "%20s%n", "Order_ID", "Customer_ID", "Name", "Quantity",
        "OrderValue");
    System.out
        .println("-----------------------------------------------------------------------------------------------");

    for (int i = 0; i < orderStatus.length; i++) {
      if (orderStatus[i] == 1) {
        System.out.printf("%10s" + "%20s" + "%20s" + "%20s" + "%20.2f%n", orderIDArry[i], customerIdSaveArray[i],
            customerNameArray[customerIdChecker(customerIdSaveArray[i])], qtyArry[i], (500.00 * qtyArry[i]));

      }
    }
    System.out
        .println("-----------------------------------------------------------------------------------------------");

    boolean Command = true;
    L7: while (Command) {
      System.out.print("Do you want to go back to main menu ( y/n ) : ");
      String command = in.next();
      char c = command.toLowerCase().charAt(0);
      if (c == 'y') {
        clearConsole();
        Command = false;
        home();

      } else {
        if (c == 'n') {
          Command = false;
          clearConsole();
          DeliverdOrder();

        } else {
          System.out.println("Please Enter Y or N onny....");

        }
      }

    }

  }

  public static void CancelledOrder() {
    Scanner in = new Scanner(System.in);

    headerScreentemp("Cancel ORDER");
    System.out
        .println("-----------------------------------------------------------------------------------------------");
    System.out.printf("%10s" + "%20s" + "%20s" + "%20s" + "%20s%n", "Order_ID", "Customer_ID", "Name", "Quantity",
        "OrderValue");
    System.out
        .println("-----------------------------------------------------------------------------------------------");

    for (int i = 0; i < orderStatus.length; i++) {
      if (orderStatus[i] == 2) {
        System.out.printf("%10s" + "%20s" + "%20s" + "%20s" + "%20.2f%n", orderIDArry[i], customerIdSaveArray[i],
            customerNameArray[customerIdChecker(customerIdSaveArray[i])], qtyArry[i], (500.00 * qtyArry[i]));

      }
    }
    System.out
        .println("-----------------------------------------------------------------------------------------------");

    boolean Command = true;
    L7: while (Command) {
      System.out.print("Do you want to go back to main menu ( y/n ) : ");
      String command = in.next();
      char c = command.toLowerCase().charAt(0);
      if (c == 'y') {
        clearConsole();
        Command = false;
        home();

      } else {
        if (c == 'n') {
          Command = false;
          clearConsole();
          CancelledOrder();

        } else {
          System.out.println("Please Enter Y or N onny....");

        }
      }

    }

  }

  // ---------------------------UpdateOderDetails---------------------
  public static void UpdateOrderDetails() {
    Scanner in = new Scanner(System.in);

    headerScreentemp("UPDATE ORDER DETAILS");
    System.out.print("Enter order ID : ");

    String orderIdInput = in.next();
    System.out.println("========================================");
    if (OrderIdChecker(orderIdInput) == -1) {
      System.out.print("Invalid order ID. Do you want to try again ( y/n ): ");
      String command = in.next();
      char c = command.toLowerCase().charAt(0);
      if (c == 'y') {
        clearConsole();
        UpdateOrderDetails();
      } else {
        if (c == 'n') {

          clearConsole();
          home();
        } else {
          System.out.println("Please enter Y or N only....");

        }
      }

    } else {

      int OrderIDIndex = OrderIdChecker(orderIdInput);

      if (orderStatus[OrderIDIndex] == 1) {
        System.out.println("This order is already Deliverd... You can not update this order..");
        System.out.print("\n");

        boolean Command = true;
        L7: while (Command) {
          System.out.print("Do you want to update another order Detail ( y/n ) : ");
          String command = in.next();
          char c = command.toLowerCase().charAt(0);
          if (c == 'y') {
            clearConsole();
            Command = false;

          } else {
            if (c == 'n') {
              Command = false;
              clearConsole();
              home();

            } else {
              System.out.println("Please Enter Y or N only....");

            }
          }

        }

      } else {
        if (orderStatus[OrderIDIndex] == 2) {
          System.out.println("This order is already Canceled... You can not update this order..");
          System.out.print("\n");

          boolean Command = true;
          L7: while (Command) {
            System.out.print("Do you want to update another order Detail ( y/n ) : ");
            String command = in.next();
            char c = command.toLowerCase().charAt(0);
            if (c == 'y') {
              clearConsole();
              Command = false;

            } else {
              if (c == 'n') {
                Command = false;
                clearConsole();
                home();

              } else {
                System.out.println("Please Enter Y or N only....");

              }
            }

          }

        } else {
          System.out.println(" Order ID            : " + orderIDArry[OrderIDIndex]);
          System.out.println(" Customer ID         : " + customerIdSaveArray[OrderIDIndex]);

          int customerID = customerIdSaveArray[OrderIDIndex];
          int customerIDIndex = 0;
          for (int i = 0; i < customerIdArray.length; i++) {
            if (customerID == customerIdArray[i]) {
              customerIDIndex = i;
            }
          }

          System.out.println(" Name                : " + customerNameArray[customerIDIndex]);
          System.out.println(" Quantity            : " + qtyArry[OrderIDIndex]);
          System.out.println(" Order Value         : " + (qtyArry[OrderIDIndex] * 500.00));
          System.out.println(" Order Status        : " + "Preparing Order");
          System.out.println("========================================");

          System.out.println("\n");
          System.out.print("What do you want to update ? ");
          System.out.println(" ");
          System.out.println("     [1]Quantity ");
          System.out.println("     [2]Status ");
          System.out.println(" ");
          int inputoption = 0;
          L1: while (true) {
            System.out.print("enter Yout Option : ");
            inputoption = in.nextInt();
            if (inputoption <= 0 | inputoption > 2) {
              System.out.println("Please enter NO:1 and No: 2 options only..");
            } else {
              break L1;
            }

          }

          switch (inputoption) {
            case 1:
              clearConsole();
              quantityUpdate(OrderIDIndex, customerIDIndex);
              break;

            case 2:
              clearConsole();
              statusUpdate(OrderIDIndex, customerIDIndex);
              break;
          }

        }

      }

    }

  }

  public static void quantityUpdate(int OrderIDIndex, int customerIDIndex) {
    Scanner in = new Scanner(System.in);
    headerScreentemp(" QUANTITY UPDATE");
    System.out.println(" Order ID            : " + orderIDArry[OrderIDIndex]);
    System.out.println(" Customer ID         : " + customerIdSaveArray[OrderIDIndex]);
    System.out.println(" Name                : " + customerNameArray[customerIDIndex]);
    System.out.println("\n");

    int newQty = 0;
    L1: while (true) {
      System.out.print("Enter your NEW QUANTITY : ");
      newQty = in.nextInt();
      if (newQty <= 0) {
        System.out.println("Please enter correct QTY....");

      } else {
        break L1;
      }
    }
    System.out.println("------> UPDATED ORDER " + orderIDArry[OrderIDIndex] + " Quantity " + qtyArry[OrderIDIndex]
        + " TO --> " + newQty + " <------");
    System.out.println(" ");
    System.out.println("New Order Quantity ----> " + newQty);
    System.out.println("New Order Value    ----> " + (newQty * 500.00));
    System.out.println(" ");

    qtyArry[OrderIDIndex] = newQty;

    boolean Command = true;
    L7: while (Command) {
      System.out.print("Do you want to update another order Detail ( y/n ) : ");
      String command = in.next();
      char c = command.toLowerCase().charAt(0);
      if (c == 'y') {
        clearConsole();
        Command = false;
        UpdateOrderDetails();

      } else {
        if (c == 'n') {
          Command = false;
          clearConsole();
          home();

        } else {
          System.out.println("Please Enter Y or N only....");

        }
      }

    }

  }

  public static void statusUpdate(int OrderIDIndex, int customerIDIndex) {

    headerScreentemp(" STATUS UPDATE");
    Scanner in = new Scanner(System.in);
    System.out.println(" Order ID            : " + orderIDArry[OrderIDIndex]);
    System.out.println(" Customer ID         : " + customerIdSaveArray[OrderIDIndex]);
    System.out.println(" Name                : " + customerNameArray[customerIDIndex]);
    System.out.println("\n");

    System.out.println("[1] Cancel");
    System.out.println("[2] Deliverd");

    int newStatus = 0;
    L1: while (true) {
      System.out.print("Enter your NEW ORDER STATUS : ");
      newStatus = in.nextInt();
      if (newStatus <= 0 | newStatus > 2) {
        System.out.println("Please enter correct Status....");

      } else {
        break L1;
      }
    }

    newStatus = newStatus == 1 ? 2 : 1;
    System.out.println("------> UPDATED ORDER STATUS <------ ");
    System.out.println(" ");
    System.out.println("New Order Status ----> " + (newStatus == 1 ? "Deliverd" : "Cancel"));
    System.out.println(" ");

    orderStatus[OrderIDIndex] = newStatus;
    if(newStatus==2){
      qtyArry[OrderIDIndex]=0;
    }




    boolean Command = true;
    L7: while (Command) {
      System.out.print("Do you want to update another order Detail ( y/n ) : ");
      String command = in.next();
      char c = command.toLowerCase().charAt(0);
      if (c == 'y') {
        clearConsole();
        Command = false;
        UpdateOrderDetails();

      } else {
        if (c == 'n') {
          Command = false;
          clearConsole();
          home();

        } else {
          System.out.println("Please Enter Y or N only....");

        }
      }

    }

  }

  // ----------------------------------------------------------------Exit---------------------
  public static void Exit() {
    clearConsole();
    System.out.println("\n\t\tYou left the program...\n");
    System.exit(0);

  }

  public static void main(String[] args) {

    home();

  }
}