package com.example.loyaltycard.fragments.bankCard.adapter

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.loyaltycard.R
import com.example.loyaltycard.data.models.BankCard
import com.example.loyaltycard.databinding.RowBankCardBinding

class BankCardRecyclerView : RecyclerView.Adapter<BankCardRecyclerView.CardViewHolder>() {

    private var list: List<BankCard> = emptyList()




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(bankCards: List<BankCard>) {
        val bankCardDiffUtil = BankCardDiffUtil(list, bankCards)
        val DiffUtilResult = DiffUtil.calculateDiff(bankCardDiffUtil)
        this.list = bankCards
        DiffUtilResult.dispatchUpdatesTo(this)
    }

    class CardViewHolder(private val binding: RowBankCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(bankCard: BankCard) {
            binding.bankCard = bankCard
            binding.executePendingBindings()

//            val scale = itemView.context.applicationContext.resources.displayMetrics.density
//            binding.cardFront.cameraDistance = 8000 * scale
//            binding.cardBack.cameraDistance = 8000 * scale
//
//
//            val frontAnim = AnimatorInflater.loadAnimator(itemView.context.applicationContext, R.animator.front_animator) as AnimatorSet
//            val backAnim = AnimatorInflater.loadAnimator(itemView.context.applicationContext, R.animator.back_animator) as AnimatorSet
//
//
//            binding.rotateFront.setOnClickListener {
//                if (bankCard.isFront  && binding.cardBack.rotationY == 0.0f || binding.cardBack.rotationY == 180.0f) {
//                    frontAnim.setTarget(binding.cardFront)
//                    backAnim.setTarget(binding.cardBack)
//                    frontAnim.start()
//                    backAnim.start()
//                    bankCard.isFront = false
//                } else if(binding.cardBack.rotationY == 0.0f) {
//                    frontAnim.setTarget(binding.cardBack)
//                    backAnim.setTarget(binding.cardFront)
//                    frontAnim.start()
//                    backAnim.start()
//                    bankCard.isFront = true
//                }
//            }
//
//            binding.rotateBack.setOnClickListener {
//                if (bankCard.isFront  && binding.cardBack.rotationY == 0.0f || binding.cardBack.rotationY == 180.0f) {
//                    frontAnim.setTarget(binding.cardFront)
//                    backAnim.setTarget(binding.cardBack)
//                    frontAnim.start()
//                    backAnim.start()
//                    bankCard.isFront = false
//                } else if(binding.cardBack.rotationY == 0.0f) {
//                    frontAnim.setTarget(binding.cardBack)
//                    backAnim.setTarget(binding.cardFront)
//                    frontAnim.start()
//                    backAnim.start()
//                    bankCard.isFront = true
//                }
//            }
//
//            itemView.setOnClickListener{
//                if (bankCard.isFront  && binding.cardBack.rotationY == 0.0f || binding.cardBack.rotationY == 180.0f) {
//                    frontAnim.setTarget(binding.cardFront)
//                    backAnim.setTarget(binding.cardBack)
//                    frontAnim.start()
//                    backAnim.start()
//                    bankCard.isFront = false
//                } else if(binding.cardBack.rotationY == 0.0f) {
//                    frontAnim.setTarget(binding.cardBack)
//                    backAnim.setTarget(binding.cardFront)
//                    frontAnim.start()
//                    backAnim.start()
//                    bankCard.isFront = true
//                }
//            }
        }
        companion object {
            fun from(parent: ViewGroup): CardViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowBankCardBinding.inflate(layoutInflater, parent, false)
                return CardViewHolder(binding)
            }
        }
    }

}