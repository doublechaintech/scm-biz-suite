

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Goods.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (goods,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{goods.id}</Description> 
<Description term="Name">{goods.name}</Description> 
<Description term="Rfid">{goods.rfid}</Description> 
<Description term="Uom">{goods.uom}</Description> 
<Description term="Max Package">{goods.maxPackage}</Description> 
<Description term="Expire Time">{ moment(goods.expireTime).format('YYYY-MM-DD')}</Description> 
<Description term="Current Status">{goods.currentStatus}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = goods => {
  const {GoodsBase} = GlobalComponents
  return <PermissionSetting targetObject={goods}  targetObjectMeta={GoodsBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class GoodsPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  goods = this.props.goods;
    const { id,displayName, goodsMovementCount } = goods
    const cardsData = {cardsName:"Goods",cardsFor: "goods",cardsSource: goods,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
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
  goods: state._goods,
}))(Form.create()(GoodsPermission))

