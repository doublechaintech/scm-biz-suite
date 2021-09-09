

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './StockCountIssueTrack.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (stockCountIssueTrack,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{stockCountIssueTrack.id}</Description> 
<Description term="头衔">{stockCountIssueTrack.title}</Description> 
<Description term="计数时间">{ moment(stockCountIssueTrack.countTime).format('YYYY-MM-DD')}</Description> 
<Description term="概览">{stockCountIssueTrack.summary}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = stockCountIssueTrack => {
  const {StockCountIssueTrackBase} = GlobalComponents
  return <PermissionSetting targetObject={stockCountIssueTrack}  targetObjectMeta={StockCountIssueTrackBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class StockCountIssueTrackPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  stockCountIssueTrack = this.props.stockCountIssueTrack
    const { id,displayName,  } = stockCountIssueTrack
    const  returnURL = `/stockCountIssueTrack/${id}/workbench`
    const cardsData = {cardsName:"库存计数问题跟踪",cardsFor: "stockCountIssueTrack",cardsSource: stockCountIssueTrack,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  stockCountIssueTrack: state._stockCountIssueTrack,
}))(Form.create()(StockCountIssueTrackPermission))

