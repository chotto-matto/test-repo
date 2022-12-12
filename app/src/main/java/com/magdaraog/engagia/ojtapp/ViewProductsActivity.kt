package com.magdaraog.engagia.ojtapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.magdaraog.engagia.ojtapp.databinding.ActivityListOfProductsBinding

class ViewProductsActivity : AppCompatActivity() {

    private lateinit var viewProductsBinding: ActivityListOfProductsBinding

    private lateinit var productsViewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewProductsBinding = ActivityListOfProductsBinding.inflate(layoutInflater)
        setContentView(viewProductsBinding.root)

        productsViewModel = ViewModelProvider(this)[ProductsViewModel::class.java]

        productsViewModel.init()

        productsViewModel.getProducts()?.observe(this, Observer {
            println("test")
            if (it.size !== 0){
                val stk: TableLayout = viewProductsBinding.firstTable
                stk.removeAllViews()
                val tbrow1: TableRow = TableRow(viewProductsBinding.root.context)
                tbrow1.setBackgroundColor(Color.parseColor("#E1E1E1"))
                val h1v: TextView = TextView(viewProductsBinding.root.context)
                h1v.setText("ID")
                h1v.setPadding(25, 25, 25, 25)
                h1v.setTextColor(Color.parseColor("#000000"))
                h1v.setTypeface(Typeface.DEFAULT_BOLD)
                tbrow1.addView(h1v)
                val lp: TableRow.LayoutParams = h1v.getLayoutParams() as TableRow.LayoutParams
                lp.width = 100
                h1v.setLayoutParams(lp)
                val h2v: TextView = TextView(viewProductsBinding.root.context)
                h2v.setText("PRODUCT CODE")
                h2v.setPadding(25, 25, 25, 25)
                h2v.setTextColor(Color.parseColor("#000000"))
                h2v.setTypeface(Typeface.DEFAULT_BOLD)
                tbrow1.addView(h2v)
                val h3v: TextView = TextView(viewProductsBinding.root.context)
                h3v.setText("PRODUCT NAME")
                h3v.setPadding(25, 25, 25, 25)
                h3v.setTextColor(Color.parseColor("#000000"))
                h3v.setTypeface(Typeface.DEFAULT_BOLD)
                tbrow1.addView(h3v)

                stk.addView(tbrow1)

                for (i in 0 until it.size) {

                    val tbrow: TableRow = TableRow(viewProductsBinding.root.context)
                    val t1v: TextView = TextView(viewProductsBinding.root.context)
                    t1v.setText(it[i].prodID.toString())
                    t1v.setPadding(25, 25, 25, 25)
                    tbrow.addView(t1v)
                    val t2v: TextView = TextView(viewProductsBinding.root.context)
                    t2v.setText(it[i].prodCode.toString())
                    t2v.setPadding(25, 25, 25, 25)
                    tbrow.addView(t2v)
                    val t3v: TextView = TextView(viewProductsBinding.root.context)
                    t3v.setText(it[i].prodName.toString())
                    t3v.setPadding(25, 25, 25, 25)
                    tbrow.addView(t3v)
                    stk.addView(tbrow)

                }
            }else{
                TODO()
            }
        })

        productsViewModel.initAllUOM()

        productsViewModel.getUOM()?.observe(this, Observer {
            println("test")
            if (it.size !== 0){
                val stk: TableLayout = viewProductsBinding.secondTable
                stk.removeAllViews()
                val tbrow1: TableRow = TableRow(viewProductsBinding.root.context)
                tbrow1.setBackgroundColor(Color.parseColor("#E1E1E1"))
                val h1v: TextView = TextView(viewProductsBinding.root.context)
                h1v.setText("ID")
                h1v.setPadding(25, 25, 25, 25)
                h1v.setTextColor(Color.parseColor("#000000"))
                h1v.setTypeface(Typeface.DEFAULT_BOLD)
                tbrow1.addView(h1v)
                val lp: TableRow.LayoutParams = h1v.getLayoutParams() as TableRow.LayoutParams
                lp.width = 100
                h1v.setLayoutParams(lp)
                val h2v: TextView = TextView(viewProductsBinding.root.context)
                h2v.setText("PRODUCT CODE")
                h2v.setPadding(25, 25, 25, 25)
                h2v.setTextColor(Color.parseColor("#000000"))
                h2v.setTypeface(Typeface.DEFAULT_BOLD)
                tbrow1.addView(h2v)
                val h3v: TextView = TextView(viewProductsBinding.root.context)
                h3v.setText("UNIT OF MEASURE")
                h3v.setPadding(25, 25, 25, 25)
                h3v.setTextColor(Color.parseColor("#000000"))
                h3v.setTypeface(Typeface.DEFAULT_BOLD)
                tbrow1.addView(h3v)
                val h4v: TextView = TextView(viewProductsBinding.root.context)
                h4v.setText("PRICE")
                h4v.setPadding(25, 25, 25, 25)
                h4v.setTextColor(Color.parseColor("#000000"))
                h4v.setTypeface(Typeface.DEFAULT_BOLD)
                tbrow1.addView(h4v)

                stk.addView(tbrow1)

                for (i in 0 until it.size) {

                    val tbrow: TableRow = TableRow(viewProductsBinding.root.context)
                    val t1v: TextView = TextView(viewProductsBinding.root.context)
                    t1v.setText(it[i].UOMId.toString())
                    t1v.setPadding(25, 25, 25, 25)
                    tbrow.addView(t1v)
                    val t2v: TextView = TextView(viewProductsBinding.root.context)
                    t2v.setText(it[i].UOMCode)
                    t2v.setPadding(25, 25, 25, 25)
                    tbrow.addView(t2v)
                    val t3v: TextView = TextView(viewProductsBinding.root.context)
                    t3v.setText(it[i].UOM)
                    t3v.setPadding(25, 25, 25, 25)
                    tbrow.addView(t3v)
                    val t4v: TextView = TextView(viewProductsBinding.root.context)
                    t4v.setText(it[i].UOMPrice)
                    t4v.setPadding(25, 25, 25, 25)
                    tbrow.addView(t4v)
                    stk.addView(tbrow)

                }
            }else{
                TODO()
            }
        })

        viewProductsBinding.btnUOMBack.setOnClickListener{
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }


}