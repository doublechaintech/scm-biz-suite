import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"产品供应时间", menuFor: "productSupplyDuration",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"产品供应时间", menuFor: "productSupplyDuration",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  quantity: '数量',
  duration: '持续时间',
  price: '价格',
  product: '产品',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'productSupplyDuration') , sorter: true },
  { title: fieldLabels.quantity, debugtype: 'int', dataIndex: 'quantity', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.duration, debugtype: 'string', dataIndex: 'duration', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.price, dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record), sorter: true  },
  { title: fieldLabels.product, dataIndex: 'product', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(productSupplyDuration,targetComponent)=>{

  const userContext = null
  return (
    <div key={productSupplyDuration.id}>
	
      <DescriptionList  key={productSupplyDuration.id} size="small" col="4">
        <Description term="序号">{productSupplyDuration.id}</Description> 
        <Description term="数量"><div style={{"color":"red"}}>{productSupplyDuration.quantity}</div></Description> 
        <Description term="持续时间">{productSupplyDuration.duration}</Description> 
        <Description term="价格"><div style={{"color":"red"}}>{productSupplyDuration.price}</div></Description> 
        <Description term="产品"><div>{productSupplyDuration.product==null?appLocaleName(userContext,"NotAssigned"):`${productSupplyDuration.product.displayName}(${productSupplyDuration.product.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const ProductSupplyDurationBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ProductSupplyDurationBase



