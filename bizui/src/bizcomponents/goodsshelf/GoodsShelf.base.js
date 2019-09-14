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


const menuData = {menuName:"货架", menuFor: "goodsShelf",
  		subItems: [
  {name: 'goodsShelfStockCountList', displayName:'货架库存盘点', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsAllocationList', displayName:'货位', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  location: '位置',
  storageSpace: '存货区',
  supplierSpace: '供应商的空间',
  damageSpace: '残次货物存放区',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsShelf') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.storageSpace, dataIndex: 'storageSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.supplierSpace, dataIndex: 'supplierSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.damageSpace, dataIndex: 'damageSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(goodsShelf,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsShelf.id}>
	
      <DescriptionList  key={goodsShelf.id} size="small" col="4">
        <Description term="序号">{goodsShelf.id}</Description> 
        <Description term="位置">{goodsShelf.location}</Description> 
        <Description term="存货区"><div>{goodsShelf.storageSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.storageSpace.displayName}(${goodsShelf.storageSpace.id})`}
        </div></Description>
        <Description term="供应商的空间"><div>{goodsShelf.supplierSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.supplierSpace.displayName}(${goodsShelf.supplierSpace.id})`}
        </div></Description>
        <Description term="残次货物存放区"><div>{goodsShelf.damageSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.damageSpace.displayName}(${goodsShelf.damageSpace.id})`}
        </div></Description>
        <Description term="最后更新时间"><div>{ moment(goodsShelf.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const GoodsShelfBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default GoodsShelfBase



