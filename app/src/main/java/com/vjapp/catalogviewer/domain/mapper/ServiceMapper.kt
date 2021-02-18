package com.vjapp.catalogviewer.domain.mapper

import com.vjapp.catalogviewer.data.remote.model.catalog.CatalogItemResponse
import com.vjapp.catalogviewer.data.remote.model.catalog.CatalogResponse
import com.vjapp.catalogviewer.data.remote.model.product.Color
import com.vjapp.catalogviewer.data.remote.model.product.ItemDescriptions
import com.vjapp.catalogviewer.data.remote.model.product.ProductResponse
import com.vjapp.catalogviewer.data.remote.model.product.Size
import com.vjapp.catalogviewer.domain.model.*

class ServiceMapper {

    companion object {

        fun mapToEntity(catalogResponse: CatalogResponse): CatalogEntity {
            return CatalogEntity(catalogResponse.items.map { el -> mapToEntity(el) })
        }

        fun mapToEntity(catalogItemResponse: CatalogItemResponse): CatalogItemEntity {
            return CatalogItemEntity(
                brandName = catalogItemResponse.brand,
                category = catalogItemResponse.microCategory,
                price = if (catalogItemResponse.formattedDiscountedPrice == catalogItemResponse.formattedFullPrice)
                    catalogItemResponse.formattedFullPrice
                else catalogItemResponse.formattedDiscountedPrice
            )
        }

        fun mapToEntity(productResponse: ProductResponse) : ProductEntity {
            with (productResponse) {
                return ProductEntity(
                    mapToEntity(itemDescriptions),
                    cod10,
                    quantity,
                    brand.name,
                    category.name,
                    price = if (formattedPrice.discountedPrice == formattedPrice.fullPrice)
                                formattedPrice.fullPrice else formattedPrice.discountedPrice,
                    colors = colors.map{ color->mapToEntity(color)},
                    sizes = sizes.map{ size->mapToEntity(size)}
                )
            }
        }

        fun mapToEntity(itemDescriptions: ItemDescriptions) : ItemDescriptionsEntity {
            with (itemDescriptions) {
                return ItemDescriptionsEntity(
                    sizeInfo,
                    productInfo,
                    brandInfo
                )
            }
        }

        fun mapToEntity(color : Color) : ColorEntity {
            with (color) {
                return ColorEntity(
                    colorId,
                    colorCode,
                    code10,
                    name,
                    rgb
                )
            }
        }

        fun mapToEntity(size : Size) : SizeEntity {
            with (size) {
                return SizeEntity(
                    id,
                    name,
                    isoTwoLetterCountryCode,
                    defaultSizeLabel,
                    alternativeSizeLabel
                )
            }
        }

    }

}