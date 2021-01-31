package hr.fer.objobl.shopking.view

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import hr.fer.objobl.shopking.R
import hr.fer.objobl.shopking.databinding.ArticleDetailsBinding
import hr.fer.objobl.shopking.utils.load
import hr.fer.objobl.shopking.view.viewstate.ArticleDetailsViewState

class ArticleDetailsSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: ArticleDetailsBinding

    private val viewState: ArticleDetailsViewState by lazy {
        requireArguments().getSerializable(ARTICLE_DETAILS_VIEW_STATE) as ArticleDetailsViewState
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.article_details, container, false)
        binding = ArticleDetailsBinding.bind(view)
        return view
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (view?.parent as View).setBackgroundColor(Color.TRANSPARENT)

        binding.articleDetailsItemName.text = viewState.name
        binding.articleDetailsItemImage.load(viewState.imageUrl)
        binding.articleDetailsItemCompany.text = viewState.company
        binding.articleDetailsItemPrice.text = viewState.price
    }

    companion object {
        const val TAG = "ArticleDetailsSheetFragment"
        const val ARTICLE_DETAILS_VIEW_STATE = "ARTICLE_DETAILS_VIEW_STATE"

        @JvmStatic
        fun newInstance(viewState: ArticleDetailsViewState) = ArticleDetailsSheetFragment().apply {
            arguments = Bundle().apply {
                putSerializable(ARTICLE_DETAILS_VIEW_STATE, viewState)
            }
        }
    }
}
