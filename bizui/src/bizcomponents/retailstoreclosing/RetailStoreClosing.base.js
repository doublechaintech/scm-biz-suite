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


const menuData = {menuName:"商店关闭", menuFor: "retailStoreClosing",
  		subItems: [
  {name: 'retailStoreList', displayName:'双链小超', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  comment: '评论',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStoreClosing') , sorter: true },
  { title: fieldLabels.comment, debugtype: 'string', dataIndex: 'comment', width: '6',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStoreClosing,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStoreClosing.id}>
	
      <DescriptionList  key={retailStoreClosing.id} size="small" col="4">
        <Description term="序号">{retailStoreClosing.id}</Description> 
        <Description term="评论">{retailStoreClosing.comment}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const RetailStoreClosingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreClosingBase



