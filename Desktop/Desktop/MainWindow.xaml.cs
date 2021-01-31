using Desktop.Content;
using Desktop.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Desktop
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        ItemContext itemContext = new ItemContext();
        RecipeContext recipeContext = new RecipeContext();
        public MainWindow()
        {
            InitializeComponent();
            dataGridItem.ItemsSource = itemContext.Items.ToList();

        }

        private void Catalogue_Click(object sender, RoutedEventArgs e)
        {
            catalogue_grid.Visibility = Visibility.Visible;
            shopping_list_grid.Visibility = Visibility.Hidden;
            wish_list_grid.Visibility = Visibility.Hidden;
            recipes_grid.Visibility = Visibility.Hidden;
            information_grid.Visibility = Visibility.Hidden;
        }

        private void Food_Click(object sender, RoutedEventArgs e) { }

        private void Beverage_Click(object sender, RoutedEventArgs e) { }
        private void Clothing_Click(object sender, RoutedEventArgs e) { }
        private void Device_Click(object sender, RoutedEventArgs e) { }
        private void Toiletry_Click(object sender, RoutedEventArgs e) { }
        private void ShoppingList_Click(object sender, RoutedEventArgs e) {
            catalogue_grid.Visibility = Visibility.Hidden;
            shopping_list_grid.Visibility = Visibility.Visible;
            wish_list_grid.Visibility = Visibility.Hidden;
            recipes_grid.Visibility = Visibility.Hidden;
            information_grid.Visibility = Visibility.Hidden;

            List<Item> shoppingList = new List<Item>();
            foreach (Item item in itemContext.Items)
            {
                if (item.ShoppingList == true)
                {
                    shoppingList.Add(item);
                }
            }
            dataGridShoppingList.ItemsSource = shoppingList;
        }
        private void WishList_Click(object sender, RoutedEventArgs e) {
            catalogue_grid.Visibility = Visibility.Hidden;
            shopping_list_grid.Visibility = Visibility.Hidden;
            wish_list_grid.Visibility = Visibility.Visible;
            recipes_grid.Visibility = Visibility.Hidden;
            information_grid.Visibility = Visibility.Hidden;

            List<Item> wishList = new List<Item>();
            foreach (Item item in itemContext.Items) 
            {
               if(item.WishList == true)
                {
                    wishList.Add(item);
                }
            }
            dataGridWishList.ItemsSource = wishList;
        }
        private void Recipes_Click(object sender, RoutedEventArgs e) {
            catalogue_grid.Visibility = Visibility.Hidden;
            shopping_list_grid.Visibility = Visibility.Hidden;
            wish_list_grid.Visibility = Visibility.Hidden;
            recipes_grid.Visibility = Visibility.Visible;
            information_grid.Visibility = Visibility.Hidden;

            //dataGridRecipes.ItemsSource = recipeContext.Recipes.ToList();
        }
        private void Information_Click(object sender, RoutedEventArgs e) {
            catalogue_grid.Visibility = Visibility.Hidden;
            shopping_list_grid.Visibility = Visibility.Hidden;
            wish_list_grid.Visibility = Visibility.Hidden;
            recipes_grid.Visibility = Visibility.Hidden;
            information_grid.Visibility = Visibility.Visible;
        }

    }
}
