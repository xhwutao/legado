package io.legado.app.ui.importbook

import android.content.Context
import androidx.documentfile.provider.DocumentFile
import io.legado.app.R
import io.legado.app.base.adapter.ItemViewHolder
import io.legado.app.base.adapter.SimpleRecyclerAdapter
import io.legado.app.utils.invisible
import io.legado.app.utils.visible
import kotlinx.android.synthetic.main.item_import_book.view.*
import org.jetbrains.anko.sdk27.listeners.onClick


class ImportBookAdapter(context: Context, val callBack: CallBack) :
    SimpleRecyclerAdapter<DocumentFile>(context, R.layout.item_import_book) {


    override fun convert(holder: ItemViewHolder, item: DocumentFile, payloads: MutableList<Any>) {
        holder.itemView.apply {
            if (item.isDirectory) {
                iv_icon.visible()
                cb_select.invisible()
            } else {
                iv_icon.invisible()
                cb_select.visible()
            }
            tv_name.text = item.name
            onClick {
                item.name?.let { name ->
                    if (item.isDirectory) {
                        callBack.findFolder(name)
                    } else {

                    }
                }
            }
        }
    }

    interface CallBack {
        fun findFolder(dirName: String)
    }

}