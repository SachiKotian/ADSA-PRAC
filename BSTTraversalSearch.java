import java.util.Scanner;

class Node
{
    int data;
    Node left, right;

    Node(int value) 
    {
        data = value;
        left = right = null;
    }
}

public class BSTTraversalSearch 
{

    // Insert a node in BST
    public static Node insertNode(Node root, int value) 
    {
        if (root == null) 
        {
            return new Node(value);
        }

        if (value < root.data)
            root.left = insertNode(root.left, value);
        else
            root.right = insertNode(root.right, value);

        return root;
    }

    // Search for a value in BST
    public static boolean searchNode(Node root, int key) 
    {
        if (root == null) 
        {
            return false;
        }

        if (key == root.data)
            return true;
        else if (key < root.data)
            return searchNode(root.left, key);
        else
            return searchNode(root.right, key);
    }

    // Preorder traversal: Root - Left - Right
    public static void printPreorder(Node root) 
    {
        if (root != null) 
        {
            System.out.print(root.data + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    // Inorder traversal: Left - Root - Right
    public static void printInorder(Node root) 
    {
        if (root != null) 
        {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    // Postorder traversal: Left - Right - Root
    public static void printPostorder(Node root) 
    {
        if (root != null) 
        {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        int n, value, choice;

        System.out.print("How many nodes do you want to insert? ");
        n = sc.nextInt();

        if (n <= 0) 
        {
            System.out.println("Invalid number of nodes. Exiting.");
            return;
        }

        for (int i = 1; i <= n; i++) 
        {
            System.out.print("Enter value " + i + ": ");
            value = sc.nextInt();
            root = insertNode(root, value);
        }

        do 
        {
            System.out.println("\nMenu:");
            System.out.println("1. Preorder Traversal");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Postorder Traversal");
            System.out.println("4. Search a Value");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Preorder Traversal: ");
                    printPreorder(root);
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Inorder Traversal: ");
                    printInorder(root);
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Postorder Traversal: ");
                    printPostorder(root);
                    System.out.println();
                    break;
                case 4:
                    System.out.print("Enter value to search: ");
                    int key = sc.nextInt();
                    boolean found = searchNode(root, key);
                    if (found)
                        System.out.println("Value found in the tree.");
                    else
                        System.out.println("Value not found in the tree.");
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close(); 
    }
}
