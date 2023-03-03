import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int floor ,room,total;
        int buyFloor,buyRoom,F,R,conFirm,search,searchFloor;
        String Client,searchName;
        String Line= "------------------------------------------";
        String Buyer="(condo[buyFloor - 1][buyRoom - 1] != null)";
        String Enter="Press Enter Continue.....";

        System.out.println("***************Setup your condo***************");

        while(true){
            System.out.print("Enter num of floor:");
            floor = input.nextInt();
            if(floor<=0){
                System.out.println("Floor can be smaller than zero");
                floor = input.nextInt();
            }else{
                break;
            }
        }
        while(true){
            System.out.print("Enter number of room:");
            room = input.nextInt();
            if(room<=0){
                System.out.println("Room..............");
                room = input.nextInt();
            }else{
                break;
            }
        }
        total = floor*room;
        System.out.println("total condo:"+ total);
    //Choose option
        String condo[][] = new String[floor][room];
        while(true) {
            System.out.println("**************WELCOME TO PENTHOUSE**************");
            System.out.println("1. Buy Condo ");
            System.out.println("2. Sell Condo ");
            System.out.println("3. Search info ");
            System.out.println("4. Display ");
            System.out.println("5. Exit Application ");
            System.out.println(Line);
            System.out.print("Choose option(1-5): ");
            int opt = input.nextInt();
            switch (opt) {
                case 1: {
                    System.out.println("**************Buy Condo**************");
                    again:
                    while (true) {
                        while (true) {
                            System.out.println("Enter the floor: ");
                            buyFloor = input.nextInt();
                            if (buyFloor <= 0) {
                                System.out.println("u cant in smaller number");
                                buyFloor = input.nextInt();
                            } else if (buyFloor > floor) {
                                System.out.println("have only " + floor + "floor");
                            } else {
                                break;
                            }
                        }
                        while (true) {
                            System.out.println("Enter Enter room: ");
                            buyRoom = input.nextInt();
                            if (buyRoom <= 0) {
                                System.out.println("u cant in smaller number");
                                buyRoom = input.nextInt();
                            } else if (buyRoom > room) {
                                System.out.println("have only " + room + "floor");
                            } else if (condo[buyFloor - 1][buyRoom - 1] != null) {
                                System.out.println(" this room was sold ");
                                System.out.println(Enter);
                                input.nextLine();
                                input.nextLine();
                                break again;
                            } else {
                                break;
                            }
                        }
                        input.nextLine();
                        System.out.println("Enter Name : ");
                        Client = input.nextLine();
                        (condo[buyFloor - 1][buyRoom - 1]) = Client;
                        System.out.println("**************Completed**************");
                        break;
                    }
                    System.out.println(Enter);
                    input.nextLine();
                    input.nextLine();
                    break;
                }
                case 2:
                {
                    System.out.println("***************Sell Condo***************");
                    //Redo is use for if user input they can input agian
                    Redo:
                    while (true) {
                        while (true) {
                            System.out.println("Enter the Floor: ");
                            //F stand for BuyFloor
                            F = input.nextInt();
                            if (F <= 0) {
                                System.out.println("Please Enter Number again");
                                F = input.nextInt();
                            } else if (F > floor) {
                                System.out.println("have only " + room + "floor");
                            } else {
                                break;
                            }
                        }
                        while (true) {
                            System.out.println("Enter Enter room: ");
                            //R stand for BuyRoom
                            R = input.nextInt();
                            if (R <= 0) {
                                //number cant negative and smaller than 0
                                System.out.println("Number start form 1");
                                R = input.nextInt();
                            } else if (R > room) {
                                System.out.println("have only " + room + "floor");
                            } else if (condo[R - 1][R - 1] == null) {
                                System.out.println(" this room was sold ");
                                break Redo;
                            } else if(condo[R - 1][R - 1] != null){
                                System.out.println("Select condo info:");
                                System.out.println("Floor"+F+"Room"+R+""+(condo[R - 1][R - 1]));
                                System.out.println("Enter 1 to confirm and 0 to cancel :");
                                conFirm = input.nextInt();
                                //Alert sms you has been deletes or sold
                                if(conFirm==1){
                                    condo[F-1][R-1] = null;
                                    System.out.println("Congratulation!! Your Condo has been Sold ");
                                }else {
                                    System.out.println("You have cancel your selection!!");
                                    break Redo;
                                }
                                break Redo;
                            } else {
                                break;
                            }
                        }
                        break;
                    }

                    System.out.println(Enter);
                    input.nextLine();
                    input.nextLine();
                    break;
                }

                case 3:
                {
                    while (true){
                        System.out.println("***************Search Information***************");
                        //have to option to choose and also have condition to recheck
                        System.out.println("1. Search by owner's name");
                        System.out.println("2. Search by floor");
                        System.out.println("3. Exit");
                        System.out.print("Choose option: ");
                        search= input.nextInt();
                        switch (search){
                            case 1:
                            {
                                System.out.println("***************Search by owner's name***************");
                                input.nextLine();
                                System.out.print("Enter owner's name: ");
                                searchName = input.nextLine();
                                //in condition if you put wrong name  owner it'll be error
                                for(int i=(floor-1); i>=0;i--){
                                    for(int j=0;j<room;j++){
                                        if(condo[i][j]!=null){
                                            System.out.println("Owner's name: ["+ (condo[i][j])+"]" );
                                        }
                                    }
                                }
                                break;
                            }
                            case 2:
                            {
                                System.out.println("***************Search by Floor***************");
                                System.out.print("Enter Floor: ");
                                searchFloor = input.nextInt();
                                //Is to check floor list only one floor and name all owner buy
                                System.out.print(" Floor ["+(searchFloor)+"]:" );
                                for(int i=0;i<condo[floor-1].length;i++){
                                    System.out.print(condo[searchFloor-1][i]+ " ");
                                }
                                System.out.println();
                                break;
                            }
                            case 3:
                                System.out.println("Close!!!");
                                break;
                        }while (search!=0);
                        break;
                    }
                    System.out.print(Enter);
                    input.nextLine();
                    input.nextLine();
                    break;
                }
                case 4:
                {
                    System.out.println("------------Display info---------");
                    System.out.println("");
                    for (int i=(floor-1); i>=0; i--) {
                        System.out.print("Floor ["+(i+1)+"]  ");
                        for (int j = 0; j < room; j++) {
                            System.out.print(condo[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println(Enter);
                    input.nextLine();
                    input.nextLine();
                    break;
                }
                case 5:
                    System.out.println("Bye Bye !!!!See you later");
                default:
                {
                    System.out.println("Our option start from(1-5");
                }

            }while (opt!=0);

        }

    }
}