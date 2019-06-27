import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

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
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'goodsShelf') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.storageSpace, dataIndex: 'storageSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.supplierSpace, dataIndex: 'supplierSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.damageSpace, dataIndex: 'damageSpace', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({goodsShelf,targetComponent})=>{

	
	
	const {GoodsShelfService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{goodsShelf.id}</Description> 
<Description term="位置">{goodsShelf.location}</Description> 
<Description term="存货区">{goodsShelf.storageSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.storageSpace.displayName}(${goodsShelf.storageSpace.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"存货区","storageSpace",GoodsShelfService.requestCandidateStorageSpace,
	      GoodsShelfService.transferToAnotherStorageSpace,"anotherStorageSpaceId",goodsShelf.storageSpace?goodsShelf.storageSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="供应商的空间">{goodsShelf.supplierSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.supplierSpace.displayName}(${goodsShelf.supplierSpace.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"供应商的空间","supplierSpace",GoodsShelfService.requestCandidateSupplierSpace,
	      GoodsShelfService.transferToAnotherSupplierSpace,"anotherSupplierSpaceId",goodsShelf.supplierSpace?goodsShelf.supplierSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="残次货物存放区">{goodsShelf.damageSpace==null?appLocaleName(userContext,"NotAssigned"):`${goodsShelf.damageSpace.displayName}(${goodsShelf.damageSpace.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"残次货物存放区","damageSpace",GoodsShelfService.requestCandidateDamageSpace,
	      GoodsShelfService.transferToAnotherDamageSpace,"anotherDamageSpaceId",goodsShelf.damageSpace?goodsShelf.damageSpace.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="最后更新时间">{ moment(goodsShelf.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(goodsShelf,targetComponent)}
      </DescriptionList>
	)

}
	



const GoodsShelfBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default GoodsShelfBase



