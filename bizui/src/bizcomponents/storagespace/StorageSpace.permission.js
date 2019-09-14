

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './StorageSpace.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <FontAwesome name="arrow-left"  /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (storageSpace,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{storageSpace.id}</Description> 
<Description term="位置">{storageSpace.location}</Description> 
<Description term="联系电话">{storageSpace.contactNumber}</Description> 
<Description term="总面积">{storageSpace.totalArea}</Description> 
<Description term="纬度">{storageSpace.latitude}</Description> 
<Description term="经度">{storageSpace.longitude}</Description> 
<Description term="最后更新时间">{ moment(storageSpace.lastUpdateTime).format('YYYY-MM-DD')}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = storageSpace => {
  const {StorageSpaceBase} = GlobalComponents
  return <PermissionSetting targetObject={storageSpace}  targetObjectMeta={StorageSpaceBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class StorageSpacePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  storageSpace = this.props.storageSpace
    const { id,displayName, goodsShelfCount } = storageSpace
    const  returnURL = `/storageSpace/${id}/dashboard`
    const cardsData = {cardsName:"存货区",cardsFor: "storageSpace",cardsSource: storageSpace,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  storageSpace: state._storageSpace,
}))(Form.create()(StorageSpacePermission))

